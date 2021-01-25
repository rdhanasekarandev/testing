package com.inses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InsesApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsesApplication.class, args);
    }
}
