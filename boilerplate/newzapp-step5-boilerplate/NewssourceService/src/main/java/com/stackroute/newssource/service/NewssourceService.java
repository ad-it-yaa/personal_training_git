package com.stackroute.newssource.service;

import java.util.List;

import com.stackroute.newssource.model.Newssource;
import com.stackroute.newssource.util.exception.NewssourceNotFoundException;

public interface NewssourceService {
	
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */


	boolean addNewssource(Newssource newssource);

	boolean deleteNewssource(int newssourceId);

	Newssource updateNewssource(Newssource newssource, int newssourceId) throws NewssourceNotFoundException;

	Newssource getNewssourceById(String userId,int newssourceId) throws NewssourceNotFoundException;

	List<Newssource> getAllNewssourceByUserId(String userId);

	
	
	
}
