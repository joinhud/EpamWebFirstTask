package com.epam.web.first.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CandiesErrorHandler extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger();

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

    @Override
    public void warning(SAXParseException e) {
        LOG.warn(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXParseException {
        LOG.error(getLineAddress(e) + " - " + e.getMessage());
        throw e;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXParseException {
        LOG.fatal(getLineAddress(e) + " - " + e.getMessage());
        throw e;
    }
}
