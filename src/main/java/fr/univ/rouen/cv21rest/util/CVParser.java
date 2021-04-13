package fr.univ.rouen.cv21rest.util;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

@Component
public class CVParser {

    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

    static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private final SAXParser parser;

    @Autowired
    public CVParser(@NotNull ResourceLoader resourceLoader) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        parser = spf.newSAXParser();
        Resource r = resourceLoader.getResource("schema/cv21.xsd");
        parser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
        parser.setProperty(JAXP_SCHEMA_SOURCE, r.getFile());
    }

    public boolean isValid(InputStream xml) throws IOException, SAXException {
        SimpleErrorHandler errorHandler = new SimpleErrorHandler();
        parser.parse(xml, errorHandler);
        return ! errorHandler.hasError();
    }
}
