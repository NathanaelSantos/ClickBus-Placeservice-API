package com.springboot.placeservice.repositories;

import com.springboot.placeservice.dtos.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PlaceRepositoy extends ReactiveCrudRepository<Place, Long> {
    Mono<Place> findByName(String name);
}
