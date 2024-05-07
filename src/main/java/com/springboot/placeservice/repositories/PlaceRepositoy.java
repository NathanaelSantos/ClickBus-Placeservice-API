package com.springboot.placeservice.repositories;

import com.springboot.placeservice.models.PlaceModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PlaceRepositoy extends ReactiveCrudRepository<PlaceModel, UUID> {
}
