package com.epam.web.first.type;

public enum CandyEnum {
    CANDIES("candies"),
    SWEET("sweet"),
    CHOCOLATE("chocolate"),
    VALUE("value"),
    INGREDIENTS("ingredients"),
    NAME("name"),
    ENERGY("energy"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    TYPE("type"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLA("vanilla"),
    COLOR("color"),
    COCOA_MASS("cocoa-mass"),
    COCOA_BUTTER("cocoa-butter");

    private String value;

    CandyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
