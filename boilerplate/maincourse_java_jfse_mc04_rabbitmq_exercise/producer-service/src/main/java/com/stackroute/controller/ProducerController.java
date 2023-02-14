package com.stackroute.controller;

import com.stackroute.domain.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    /*
     * Add code to autowire RabbitMQSender
     */

    /**
     * To get the property values
     */
    @Value("${app.message}")
    private String message;


    @PostMapping(value = "employee")
    public String publishEmployeeDetails(@RequestBody Employee employee) {

        /*
         * Add code to send employee object to RabbitMQ
         */

        return message;
    }

}
