package com.example.wogeoji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WogeojiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WogeojiApplication.class, args);
    }

}
