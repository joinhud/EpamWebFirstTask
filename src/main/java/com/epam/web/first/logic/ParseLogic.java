package com.epam.web.first.logic;

import com.epam.web.first.builder.AbstractCandiesBuilder;
import com.epam.web.first.entity.Candy;
import com.epam.web.first.exception.CandiesBuilderFactoryException;
import com.epam.web.first.factory.CandiesBuilderFactory;
import com.epam.web.first.upload.FileUploader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Set;

public class ParseLogic {
    private static final Logger LOG = LogManager.getLogger();

    private static final String FILES_DIRECTORY = "uploadFiles";
    private static final String PARAM_XML_FILE = "xmlFile";
    private static final String PARAM_XSD_FILE = "xsdFile";

    public static Set<Candy> parse(HttpServletRequest request, String typeParser, FileUploader uploader) {
        CandiesBuilderFactory factory = new CandiesBuilderFactory();
        Set<Candy> result = null;

        String xmlFile = uploader.upload(PARAM_XML_FILE);
        String xsdFile = uploader.upload(PARAM_XSD_FILE);

        String rootPath = request.getServletContext().getRealPath(FILES_DIRECTORY);

        try {
            if (xmlFile != null && xsdFile != null) {
                AbstractCandiesBuilder builder = factory.createCandiesBuilder(typeParser);
                builder.buildSetCandies(rootPath + File.separator + xmlFile, rootPath + File.separator + xsdFile);
                result = builder.getCandies();
            }
        } catch (CandiesBuilderFactoryException e) {
            LOG.log(Level.ERROR, e);
        }

        return result;
    }
}
