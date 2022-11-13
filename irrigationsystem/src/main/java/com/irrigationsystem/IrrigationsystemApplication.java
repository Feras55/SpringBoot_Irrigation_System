package com.irrigationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IrrigationsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrrigationsystemApplication.class, args);
    }

}
