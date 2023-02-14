package com.nwmortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwmortgage.dao.AuthenticationRepo;
import com.nwmortgage.model.Register;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private AuthenticationRepo authRepo;

	
	@Override
	public Register findByCustidAndPassword(int custid, String password) {
		// TODO Auto-generated method stub
		return authRepo.findByCustidAndPassword(custid, password) ;
	}


	@Override
	public Register findByCustid(int custid) {
		// TODO Auto-generated method stub
		return authRepo.findByCustid(custid) ;
	}


	 
}
