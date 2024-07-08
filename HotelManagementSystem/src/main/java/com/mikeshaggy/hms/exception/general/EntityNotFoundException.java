package com.mikeshaggy.hms.exception.general;

public class EntityNotFoundException extends RuntimeException {
    private Number id;
    private String name;

    public EntityNotFoundException(Number id, String name) {
        super("%s with id %d not found".formatted(name, id.longValue()));
    }
}
