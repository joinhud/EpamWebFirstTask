package com.epam.web.first.factory;

import com.epam.web.first.builder.AbstractCandiesBuilder;
import com.epam.web.first.builder.CandiesDOMBuilder;
import com.epam.web.first.builder.CandiesSAXBuilder;
import com.epam.web.first.builder.CandiesStAXBuilder;
import com.epam.web.first.exception.CandiesBuilderFactoryException;

public class CandiesBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractCandiesBuilder createCandiesBuilder(String typeParser) throws CandiesBuilderFactoryException {
        if (typeParser == null) {
            throw new CandiesBuilderFactoryException("Transmittable object is null.");
        }

        TypeParser type;

        try {
            type = TypeParser.valueOf(typeParser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CandiesBuilderFactoryException("Unknown type of builder.", e);
        }

        switch (type) {
            case DOM:
                return new CandiesDOMBuilder();
            case SAX:
                return new CandiesSAXBuilder();
            case STAX:
                return new CandiesStAXBuilder();
            default:
                throw new CandiesBuilderFactoryException("Unknown type of builder.");
        }
    }
}
