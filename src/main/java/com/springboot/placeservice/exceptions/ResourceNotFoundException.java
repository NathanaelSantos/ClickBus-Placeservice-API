package com.springboot.placeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(String exception) {
        super(exception);
    }
}
