package com.epam.web.first.builder;

import com.epam.web.first.entity.Candy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractCandiesBuilder {
    protected Set<Candy> candies;

    public AbstractCandiesBuilder() {
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public List<String> getCandiesStrings() {
        return candies.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public boolean checkFileName(String fileName) {
        return fileName != null;
    }

    public boolean checkSchemaName(String schemaName) {
        return schemaName != null;
    }

    public abstract void buildSetCandies(String fileName, String schemaName);
}
