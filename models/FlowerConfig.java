package com.lab.FlowerLand.tour;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlowerConfig {

    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository repository) {
        return args -> {
            Flower flower1 = new Flower(
                    "Roze",
                    150,
                    "https://cdn.theculturetrip.com/wp-content/uploads/2018/01/_05.jpg"
            );

            Flower flower2 = new Flower(
                    "Roze",
                    150,
                    "https://cdn.theculturetrip.com/wp-content/uploads/2018/01/_05.jpg"

            );
            Flower flower3 = new Flower(
                    "Roze",
                    150,
                    "https://cdn.theculturetrip.com/wp-content/uploads/2018/01/_05.jpg"

            );
            Flower flower4 = new Flower(
                    "Roze",
                    150,
                    "https://cdn.theculturetrip.com/wp-content/uploads/2018/01/_05.jpg"

            );
            repository.saveAll(List.of(flower1, flower2, flower3, flower4));
        };
    }
}