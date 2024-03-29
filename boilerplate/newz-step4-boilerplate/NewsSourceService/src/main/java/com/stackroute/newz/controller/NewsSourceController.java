package com.stackroute.newz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.service.NewsSourceService;
import com.stackroute.newz.util.exception.NewsSourceAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 * 
 * Please note that the default path to use this controller should be "/api/v1/newssource"
 */

public class NewsSourceController {

	/*
	 * Autowiring should be implemented for the NewsSourceService. Please note that we
	 * should not create any object using the new keyword
	 */
	

	/*
	 * Define a handler method which will create a news source by reading the Serialized
	 * news object from request body and save the news source in news table in mongodb.
	 * Please note that the sourceId has to be unique.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 201(CREATED - In case of successful creation of the news source
	 * 2. 409(CONFLICT) - In case of duplicate sourceId
	 * 
	 * This handler method should map to the URL "/api/v1/newssource" using HTTP POST
	 * method".
	 */
	

	/*
	 * Define a handler method which will delete a newsSource from the mongodb.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the newsSource deleted successfully. 
	 * 2. 404(NOT FOUND) - If the newsSource with specified sourceId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/newssource/{sourceId}" using HTTP
	 * Delete method" where "sourceId" should be replaced by a valid sourceId without {}
	 */
    

    /*
	 * Define a handler method which will update a specific news source by reading the
	 * Serialized object from request body and save the updated news details in
	 * mongodb and handle NewsSourceNotFoundException as well. 
	 * 
	 * This handler method should return any one of the status
	 * messages basis on different situations: 
	 * 1. 200(OK) - If the news source is updated successfully. 
	 * 2. 404(NOT FOUND) - If the news source with specified sourceId is not found. 
	 * 
	 * This handler method should map to the URL "/api/v1/newssource/{sourceId}" using HTTP PUT
	 * method, where "sourceId" should be replaced by a valid sourceId without {}
	 */
    

    /*
	 * Define a handler method which will get us the news source by a sourceId.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the news source is found successfully. 
	 * 2. 404(NOT FOUND) - If the news source with specified sourceId is not found. 
	 * 
	 * 
	 * This handler method should map to the URL "/api/v1/newssource?sourceId={sourceId}" using HTTP GET
	 * method, where "sourceId" is a request parameter and should be replaced by a valid sourceId without {}
	 */
    
	
	
    /*
	 * Define a handler method which will get us all news sources.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If all news sources found successfully. 
	 * 
	 *
	 * This handler method should map to the URL "/api/v1/newssource" using HTTP GET
	 * method.
	 */
    

}
