package com.springboot.placeservice.services;

import com.github.slugify.Slugify;
import com.springboot.placeservice.apis.PlaceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceServiceTest {

    Slugify slugify;
    @Autowired
    WebTestClient webTestClient;

    public PlaceServiceTest() {
        this.slugify = Slugify.builder().build();
    }

    @Test
    void createPlace() {

        var place = new PlaceRequest("Itabaiana", "Sergipe");

        webTestClient
                .post()
                .uri("/places")
                .bodyValue(place)
                .exchange()
                .expectBody()
                .jsonPath("name").isEqualTo(place.name())
                .jsonPath("state").isEqualTo(place.state())
                .jsonPath("slug").isEqualTo(slugify.slugify(place.name()))
                .jsonPath("createdAt").isNotEmpty()
                .jsonPath("updatedAt").isNotEmpty();
    }

    @Test
    void shouldFailWhenNameIsEmpty() {
        var place = new PlaceRequest("", "São Paulo");
        webTestClient.post()
                .uri("/places")
                .bodyValue(place)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void shouldFailWhenNameAndStateAreEmpty() {
        var place = new PlaceRequest("", "");
        webTestClient.post()
                .uri("/places")
                .bodyValue(place)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void shouldFailWhenCreatingDuplicatePlace() {
        var place1 = new PlaceRequest("Gloria", "Sergipe");
        webTestClient.post()
                .uri("/places")
                .bodyValue(place1)
                .exchange()
                .expectStatus()
                .isCreated();

        var place2 = new PlaceRequest("Gloria", "Sergipe");
        webTestClient.post()
                .uri("/places")
                .bodyValue(place2)
                .exchange()
                .expectStatus()
                .isEqualTo(500);
    }

    @Test
    void getPlace() {
        webTestClient.get()
                .uri("/places/get/1")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void getPlaceFailure() {

        var place = new PlaceRequest("Rio", "Rio");

        webTestClient
                .post()
                .uri("/places")
                .bodyValue(place)
                .exchange()
                .expectBody()
                .jsonPath("name").isEqualTo(place.name())
                .jsonPath("state").isEqualTo(place.state())
                .jsonPath("slug").isEqualTo(slugify.slugify(place.name()))
                .jsonPath("createdAt").isNotEmpty()
                .jsonPath("updatedAt").isNotEmpty();

        webTestClient.get()
                .uri("/places/get/2")
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}