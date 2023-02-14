package com.stackroute.newz.service;


/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

public class UserNewsServiceImpl  implements UserNewsService {

	/*
	 * Autowiring should be implemented for the UserNewsRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */


	/* This method should be used to delete all news for a  specific userId. */

	@Override
	public void deleteAllNewsBySource(String userId, String newsSourceId) {
			
	}

}
