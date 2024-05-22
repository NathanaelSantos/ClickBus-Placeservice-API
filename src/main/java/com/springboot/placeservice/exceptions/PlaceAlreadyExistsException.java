package com.springboot.placeservice.exceptions;

public class PlaceAlreadyExistsException extends RuntimeException {
    private static Long serialVersionUID = 1L;

    public PlaceAlreadyExistsException(String exception) {
        super(exception);
    }
}
