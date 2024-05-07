package com.springboot.placeservice.dtos;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public record Place(
        UUID id,
        String name,
        String slug,
        String state,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
}
