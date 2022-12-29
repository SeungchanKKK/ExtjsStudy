package com.example.java21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Java21Application {

    public static void main(String[] args) {
        SpringApplication.run(Java21Application.class, args);
    }

}
