package com.springboot.placeservice.controllers;

import com.springboot.placeservice.apis.PlaceRequest;
import com.springboot.placeservice.apis.PlaceResponse;
import com.springboot.placeservice.mappers.PlaceMapper;
import com.springboot.placeservice.services.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> createPlace(@Valid @RequestBody PlaceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                placeService.create(request).map(PlaceMapper::fromPlaceToResponse)
        );
    }

    @GetMapping("/findAll")
    public ResponseEntity<Flux<PlaceResponse>> getAll() {
        return ResponseEntity.ok().body(
                placeService.getAll().map(PlaceMapper::fromPlaceToResponse)
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<PlaceResponse>> getPlaceId(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                placeService.findById(id).map(PlaceMapper::fromPlaceToResponse)
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Mono<PlaceResponse>> getPlace(@PathVariable String name) {
        return ResponseEntity.ok().body(
                placeService.findByName(name).map(PlaceMapper::fromPlaceToResponse)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePlace(@PathVariable Long id, @RequestBody PlaceRequest newPlace) {
        return ResponseEntity.status(HttpStatus.OK).body(
                placeService.updatePlace(id, newPlace).map(PlaceMapper::fromPlaceToResponse)
        );
    }
}
