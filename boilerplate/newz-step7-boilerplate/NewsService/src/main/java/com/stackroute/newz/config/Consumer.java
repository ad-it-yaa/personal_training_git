package com.stackroute.newz.config;

import org.springframework.stereotype.Component;

import com.stackroute.newz.dto.NewsSourceDTO;

@Component
public class Consumer {

	/*
	 * Autowiring of UserNewsService should be implemented for the Consumer. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword
	 */

 
  /* 
   * User @RabbitListerner for the method and call the deleteAllNewsBySource method 
   * (using newsSourceDTO fields) of UserNewsService
   */
	
  public void deleteNewsForSouceId(NewsSourceDTO newsSourceDto){

  }

  
}
