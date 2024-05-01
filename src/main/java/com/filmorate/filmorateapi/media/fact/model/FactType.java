package com.filmorate.filmorateapi.media.fact.model;

public enum FactType {
    MOVIE("movie"),
    PERSON("person"),
    SERIES("series"),
    EPISODE("episode");

    private final String type;

    FactType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
