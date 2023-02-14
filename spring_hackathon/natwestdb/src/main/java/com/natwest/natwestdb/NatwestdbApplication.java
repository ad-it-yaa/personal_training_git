package com.natwest.natwestdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.natwestdb.filter.JwtValidationFilter;


@EnableDiscoveryClient
@SpringBootApplication
public class NatwestdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatwestdbApplication.class, args);
	}
	
//	@Bean 
//	public FilterRegistrationBean jwtFilter() {
//		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		registrationBean.setFilter(new JwtValidationFilter());
//		registrationBean.addUrlPatterns("/api/natwestdb/get");
//		
//		return registrationBean;
//		
//	}


}
