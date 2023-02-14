package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Enables Spring Boot auto config and component scanning.
 */
@SpringBootApplication

/**
 * Add annotation to make your Spring Boot application
 * acts as a Eureka Client
 */
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
