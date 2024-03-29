package com.stackroute.newz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*As in this class we are implementing Swagger So annotate the class with @Configuration and 
 * @EnableSwagger2
 * 
 */

public class SwaggerConfig {

	/*
	 * Annotate this method with @Bean. This method will return an Object of Docket.
	 * This method will implement logic for swagger
	 */
	
	public Docket customImplementation() {
		return null;
	}

}
