package com.springboot.placeservice.controllers;

import com.springboot.placeservice.apis.PlaceRequest;
import com.springboot.placeservice.apis.PlaceResponse;
import com.springboot.placeservice.dtos.Place;
import com.springboot.placeservice.mappers.PlaceMapper;
import com.springboot.placeservice.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody PlaceRequest request){
        var placeResponseMono = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponseMono);
    }
}
