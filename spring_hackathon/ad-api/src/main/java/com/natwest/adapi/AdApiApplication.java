package com.natwest.adapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AdApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdApiApplication.class, args);
	}

}
