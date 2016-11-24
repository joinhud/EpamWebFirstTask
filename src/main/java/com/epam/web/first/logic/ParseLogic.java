package com.epam.web.first.logic;

import com.epam.web.first.builder.AbstractCandiesBuilder;
import com.epam.web.first.entity.Candy;
import com.epam.web.first.exception.CandiesBuilderFactoryException;
import com.epam.web.first.factory.CandiesBuilderFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class ParseLogic {
    private static final Logger LOG = LogManager.getLogger();

    private static final String CANDIES_FILE_XML = "files/candies.xml";
    private static final String CANDIES_FILE_XSD = "files/candies.xsd";

    public static Set<Candy> parse(HttpServletRequest request, String typeParser) {
        CandiesBuilderFactory factory = new CandiesBuilderFactory();
        Set<Candy> result = null;
        String rootPath = request.getServletContext().getRealPath("");

        try {
            AbstractCandiesBuilder builder = factory.createCandiesBuilder(typeParser);
            builder.buildSetCandies(rootPath + CANDIES_FILE_XML, rootPath + CANDIES_FILE_XSD);
            result = builder.getCandies();
        } catch (CandiesBuilderFactoryException e) {
            LOG.log(Level.ERROR, e);
        }

        return result;
    }
}
