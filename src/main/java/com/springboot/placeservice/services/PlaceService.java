package com.springboot.placeservice.services;

import com.springboot.placeservice.repositories.PlaceRepositoy;

public class PlaceService {
    private PlaceRepositoy repositoy;

    public PlaceService(PlaceRepositoy repositoy) {
        this.repositoy = repositoy;
    }
}
