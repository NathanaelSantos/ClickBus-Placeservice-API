package com.springboot.placeservice.mappers;

import com.springboot.placeservice.apis.PlaceResponse;
import com.springboot.placeservice.dtos.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.id(), place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
