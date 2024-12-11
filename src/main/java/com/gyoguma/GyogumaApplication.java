package com.gyoguma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GyogumaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GyogumaApplication.class, args);
    }

}
