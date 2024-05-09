package com.springboot.placeservice.services;

import com.springboot.placeservice.apis.PlaceRequest;
import com.springboot.placeservice.dtos.Place;
import com.springboot.placeservice.repositories.PlaceRepositoy;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepositoy repositoy;

    public PlaceService(PlaceRepositoy repositoy) {
        this.repositoy = repositoy;
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        return repositoy.save(place);
    }
}
