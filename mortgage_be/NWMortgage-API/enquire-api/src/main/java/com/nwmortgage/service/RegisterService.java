package com.nwmortgage.service;

import java.util.List;
import java.util.Optional;

import com.nwmortgage.model.Enquiry;
 


public interface RegisterService {
	
	public Enquiry addUser(Enquiry user);
	public List<Enquiry> userList();
	public Enquiry updateUser(Enquiry user);
	public Optional<Enquiry> getBySno(int sno);
	 
	}


