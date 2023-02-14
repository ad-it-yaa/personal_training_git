package com.stackroute.newssource.service;

import java.util.List;

import com.stackroute.newssource.model.Newssource;
import com.stackroute.newssource.util.exception.NewssourceNotFoundException;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */


public class NewssourceServiceImpl implements NewssourceService {

	/*
	 * Autowiring should be implemented for the NewsDao and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	/*
	 * This method should be used to save a newssource.
	 */

	@Override
	public boolean addNewssource(Newssource newssource) {
		return false;
	}

	/* This method should be used to delete an existing newssource. */

	@Override
	public boolean deleteNewssource(int newssourceId) {
		return false;
	}

	/* This method should be used to update an existing newssource. */
	
	@Override
	public Newssource updateNewssource(Newssource newssource, int newssourceId) throws NewssourceNotFoundException {
		return null;
	}

	/* This method should be used to get a specific newssource for an user. */

	@Override
	public Newssource getNewssourceById(String userId, int newssourceId) throws NewssourceNotFoundException {
		return null;
	}

	
	 /* This method should be used to get all newssource for a specific userId.*/

	@Override
	public List<Newssource> getAllNewssourceByUserId(String createdBy) {
		return null;
	}

}
