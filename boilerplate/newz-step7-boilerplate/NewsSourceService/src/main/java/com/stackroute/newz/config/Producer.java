package com.stackroute.newz.config;


import org.springframework.stereotype.Component;

import com.stackroute.newz.dto.NewsSourceDTO;



@Component
public class Producer {

	

	/*
	 * Autowiring of RabbitTemplate and DirectExchange should be implemented for the Producer. 
	 * (Use Constructor-based autowiring) Please note that we should not create any object 
	 *  using the new keyword
	 */

 
    /* 
     * Write the code to convert and send the message to RabbitMQ 
     * 
     */
	

	  public void sendMessagetoRabbitMq(NewsSourceDTO newssourceDto){
	
	  }

  
}
