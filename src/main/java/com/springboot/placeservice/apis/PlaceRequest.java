package com.springboot.placeservice.apis;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(@NotBlank String name, @NotBlank String state) {
}
