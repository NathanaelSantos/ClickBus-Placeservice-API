package com.springboot.placeservice.exceptions;

public class PlacePersistenceException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public PlacePersistenceException(String exception) {
        super(exception);
    }
}
