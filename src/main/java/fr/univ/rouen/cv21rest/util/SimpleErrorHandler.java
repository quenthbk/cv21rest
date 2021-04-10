package fr.univ.rouen.cv21rest.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleErrorHandler extends DefaultHandler implements ErrorHandler {

    /**
     * Indique si une erreur a été rencontrée
     */
    private boolean errorOccurred = false;

    @Override
    public void warning(SAXParseException e) throws SAXException {
        errorOccurred = true;
        throw e;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        errorOccurred = true;
        throw e;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        errorOccurred = true;
        throw e;
    }

    /**
     * Renvoie true si une erreur a été rencontrée, false sinon
     *
     * @return true si une erreur a été rencontrée, false sinon
     */
    public boolean hasError() {
        return errorOccurred;
    }
}
