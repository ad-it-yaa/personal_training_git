package com.nwmortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class RegisterApiApp {
	public static void main(String[] args) {
		SpringApplication.run(RegisterApiApp.class, args);
	}
	
}
