package com.epam.web.first.builder;

import com.epam.web.first.handler.CandyHandler;
import com.epam.web.first.validate.XMLValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class CandiesSAXBuilder extends AbstractCandiesBuilder {
    private static final Logger LOG = LogManager.getLogger();

    private CandyHandler handler;
    private XMLReader reader;

    public CandiesSAXBuilder() {
        handler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    @Override
    public void buildSetCandies(String fileName, String schemaName) {
        if (!checkFileName(fileName) || !checkSchemaName(schemaName)) {
            LOG.log(Level.ERROR, "One of transmittable parameters object is null.");
            return;
        }

        if (!XMLValidator.validate(fileName, schemaName)) {
            return;
        }

        XMLValidator.validate(fileName, schemaName);
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            LOG.log(Level.ERROR, e);
        }
        candies = handler.getCandies();
    }
}
