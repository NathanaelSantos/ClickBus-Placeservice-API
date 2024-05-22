package com.springboot.placeservice.services;

import com.github.slugify.Slugify;
import com.springboot.placeservice.apis.PlaceRequest;
import com.springboot.placeservice.dtos.Place;
import com.springboot.placeservice.exceptions.PlaceAlreadyExistsException;
import com.springboot.placeservice.exceptions.PlacePersistenceException;
import com.springboot.placeservice.exceptions.ResourceNotFoundException;
import com.springboot.placeservice.repositories.PlaceRepositoy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepositoy repository;
    private Slugify slfy;

    public PlaceService(PlaceRepositoy repositoy) {
        this.repository = repositoy;
        this.slfy = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest) {

        var place = new Place(null,
                placeRequest.name(),
                slfy.slugify(placeRequest.name()),
                placeRequest.state(),
                null,
                null);

        return repository.save(place)
                .onErrorResume(DataIntegrityViolationException.class,
                        e -> Mono.error(new PlaceAlreadyExistsException("A place with the same ID already exists in the database.")))
                .onErrorResume(
                        e -> Mono.error(new PlacePersistenceException("Error while creating the place: " + e.getMessage()))
                );
    }

    public Flux<Place> getAll() {
        return repository.findAll();
    }

    public Mono<Place> findById(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Place not found with id: " + id)));
    }

    public Mono<Place> findByName(String name) {
        return repository.findByName(name);
    }

    public Mono<Place> updatePlace(Long id, PlaceRequest newPlace) {
        return repository.findById(id)
                .flatMap(existingPlace -> updatePlace(existingPlace, newPlace))
                .switchIfEmpty(Mono.error(new ChangeSetPersister.NotFoundException()));
    }

    private Mono<Place> updatePlace(Place existingPlace, PlaceRequest newPlace) {
        return repository.save(
                new Place(
                        existingPlace.id(),
                        newPlace.name() != null ? newPlace.name() : existingPlace.name(),
                        slfy.slugify(newPlace.name()),
                        newPlace.state() != null ? newPlace.state() : existingPlace.state(),
                        existingPlace.createdAt(),
                        existingPlace.updatedAt()
                )
        );
    }
}
