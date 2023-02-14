package com.nwmortgage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nwmortgage.filter.APIFilter;

@Configuration
public class ApiGatewayConfig {
	
	@Autowired
	private APIFilter apiFilter;

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()


					.route(r -> r.path("/nwml/api/loan/**")
							.filters(f -> f.filters(apiFilter))
							.uri("http://localhost:8085"))
					.route(r -> r.path("/api/admin/**")
							.filters(f -> f.filters(apiFilter))
							.uri("http://localhost:8089"))

					.build();
	}
	
	

	
}
