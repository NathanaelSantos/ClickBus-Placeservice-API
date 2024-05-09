package com.springboot.placeservice.services;

import com.github.slugify.Slugify;
import com.springboot.placeservice.apis.PlaceRequest;
import com.springboot.placeservice.dtos.Place;
import com.springboot.placeservice.repositories.PlaceRepositoy;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepositoy repositoy;
    private Slugify slfy;

    public PlaceService(PlaceRepositoy repositoy) {
        this.repositoy = repositoy;
        this.slfy = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), slfy.slugify(placeRequest.name()), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        return repositoy.save(place);
    }
}
