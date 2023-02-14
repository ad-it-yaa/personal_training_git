package com.natwest.natwestdb.service;

import java.util.List;
import java.util.Optional;

import com.natwest.natwestdb.exception.userexist;
import com.natwest.natwestdb.model.Natwestdb;

public interface NatwestdbService {

	public Natwestdb adduser(Natwestdb obj) throws userexist;
	public List<Natwestdb> getuser();
	public void deleteuser(String id);
	public List<Natwestdb> userlist(String id);
	
	
}
