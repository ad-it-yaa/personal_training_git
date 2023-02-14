package com.natwest.authenticationapi.service;

import java.util.Optional;

import com.natwest.authenticationapi.model.Natwestdb;


public interface NatwestdbService {
	


	public Natwestdb findByIdAndPassword(String id, String password);
	
	
}
	
