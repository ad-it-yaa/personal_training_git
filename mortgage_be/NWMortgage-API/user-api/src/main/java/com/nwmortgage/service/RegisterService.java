package com.nwmortgage.service;

import java.util.List;

import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Register;


public interface RegisterService {
	
	public Register addUser(Register user) throws UserAlreadyExists;
	public List<Register> userList();
	public Register updateUser(Register user);
	public Register getByCustid(int custid) throws UserNotFound;
	 
	}


