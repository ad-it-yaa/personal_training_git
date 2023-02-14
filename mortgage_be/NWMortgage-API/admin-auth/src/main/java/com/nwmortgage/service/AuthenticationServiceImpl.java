package com.nwmortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwmortgage.dao.AuthenticationRepo;
import com.nwmortgage.model.Admin;
 

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private AuthenticationRepo authRepo;

	@Override
	public Admin findByEmpidAndPassword(int empid, String password) {
		// TODO Auto-generated method stub
		return authRepo.findByEmpidAndPassword(empid, password) ;
	}

	@Override
	public Admin findByEmpid(int empid) {
		// TODO Auto-generated method stub
		return authRepo.findByEmpid(empid) ;
	}

	



	 
}
