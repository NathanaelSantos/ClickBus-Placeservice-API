package com.springboot.placeservice.configs;

import com.springboot.placeservice.repositories.PlaceRepositoy;
import com.springboot.placeservice.services.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepositoy placeRepositoy){
        return new PlaceService(placeRepositoy);
    }
}
