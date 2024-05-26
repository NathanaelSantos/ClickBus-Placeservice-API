package com.springboot.placeservice.apis;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(@NotBlank String name, @NotBlank String state) {
    public PlaceRequest {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if (state == null || state.isBlank())
            throw new IllegalArgumentException("State cannot be null or empty");
    }
}
