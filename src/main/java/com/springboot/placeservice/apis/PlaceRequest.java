package com.springboot.placeservice.apis;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PlaceRequest(@NotBlank String name, @NotBlank String state) {
}
