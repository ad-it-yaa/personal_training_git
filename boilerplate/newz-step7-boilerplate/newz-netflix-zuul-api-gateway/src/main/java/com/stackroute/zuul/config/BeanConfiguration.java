package com.stackroute.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class BeanConfiguration {

	// Include Bean definition for CorsFilter
	@Bean
	public CorsFilter corsConfigurer() {
	    return null;
	}
	
}
