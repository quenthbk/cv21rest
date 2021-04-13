package fr.univ.rouen.cv21rest.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.util.SimpleErrorHandler;
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
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Component
public class CVXMLValidatorImpl implements CVXMLValidator {

    static private final String CV21_XSD_PATH = "classpath:/static/schema/cv21.xsd";

    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

    static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private static final Logger LOGGER = LoggerFactory.getLogger(CVXMLValidatorImpl.class);

    private final SAXParser parser;

    private final ObjectMapper mapper;

    private String message;

    @Autowired
    public CVXMLValidatorImpl(ResourceLoader resourceLoader, MappingJackson2XmlHttpMessageConverter xmlConverter)
            throws ParserConfigurationException, SAXException, IOException {

        // Récupération d'une instance de la factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);

        // Configuration du parser
        parser = spf.newSAXParser();
        parser.setProperty(JAXP_SCHEMA_LANGUAGE, XMLConstants.W3C_XML_SCHEMA_NS_URI);
        parser.setProperty(JAXP_SCHEMA_SOURCE, resourceLoader.getResource(CV21_XSD_PATH).getInputStream());

        // Récupération du mapper
        this.mapper = xmlConverter.getObjectMapper();
    }

    @Override
    synchronized public boolean isValid(CVDTO cv) {
        try {
            byte[] cvXml = mapper.writeValueAsBytes(cv);
            System.out.println(mapper.writeValueAsString(cv));
            parser.parse(new ByteArrayInputStream(cvXml), new SimpleErrorHandler());
            return true;
        } catch (SAXException e) {
            message = e.getMessage();
            LOGGER.info(e.getMessage());
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            message = e.getMessage();
        } catch (IOException e) {
            LOGGER.error(getMessage());
            e.printStackTrace();
            message = e.getMessage();
        }
        return false;
    }

    @Override
    synchronized public boolean isValid(InputStream cv) {
        try {
            parser.parse(cv, new SimpleErrorHandler());
            return true;
        } catch (SAXException e) {
            message = e.getMessage();
            e.printStackTrace();
            LOGGER.info(e.getMessage());
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error(getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    synchronized public String getMessage() {
        String old = message;
        this.message = null;
        return old;
    }
}
