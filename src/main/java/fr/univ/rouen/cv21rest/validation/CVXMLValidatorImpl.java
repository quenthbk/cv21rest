package fr.univ.rouen.cv21rest.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ.rouen.cv21rest.dto.CVDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class CVXMLValidatorImpl implements CVXMLValidator {

    static private final String CV21_XSD_PATH = "classpath:/static/schema/cv21.xsd";

    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private static final Logger LOGGER = LoggerFactory.getLogger(CVXMLValidatorImpl.class);

    private final SAXParserFactory spf;

    private final ObjectMapper mapper;

    private final Resource cv21xsd;

    @Autowired
    public CVXMLValidatorImpl(ResourceLoader resourceLoader, MappingJackson2XmlHttpMessageConverter xmlConverter)
            throws ParserConfigurationException, SAXException, IOException {

        // Récupération d'une instance de la factory
        spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);

        cv21xsd = resourceLoader.getResource(CV21_XSD_PATH);

        // Récupération du mapper
        this.mapper = xmlConverter.getObjectMapper();
    }

    @Override
    public boolean isValid(CVDTO cv, MessageResult result) {
        String message;

        try {
            SAXParser parser = spf.newSAXParser();
            parser.setProperty(JAXP_SCHEMA_LANGUAGE, XMLConstants.W3C_XML_SCHEMA_NS_URI);
            parser.setProperty(JAXP_SCHEMA_SOURCE, cv21xsd.getInputStream());
            byte[] cvXml = mapper.writeValueAsBytes(cv);
            parser.parse(new ByteArrayInputStream(cvXml), new SimpleErrorHandler());
            return true;
        } catch (SAXException e) {
            message = e.getMessage();
        } catch (IOException | ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            message = e.getMessage();
        }

        result.setMessage(message);

        return false;
    }
}
