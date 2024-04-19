package com.filmorate.filmorateapi.media.event;

public enum EventType {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED");

    private final String type;

    EventType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
