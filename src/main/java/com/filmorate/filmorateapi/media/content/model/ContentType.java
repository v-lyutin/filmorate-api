package com.filmorate.filmorateapi.media.content.model;

public enum ContentType {
    VIDEO("video"),
    TRAILER("trailer"),
    SCREENSHOT("screenshot"),
    ALL("all");

    private final String type;

    ContentType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
