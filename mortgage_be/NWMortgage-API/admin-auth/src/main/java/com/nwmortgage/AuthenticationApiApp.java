package com.nwmortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan
public class AuthenticationApiApp {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApiApp.class, args);
	}
}
