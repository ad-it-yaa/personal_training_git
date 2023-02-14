package com.natwest.authenticationapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.authenticationapi.dao.NatwestdbRepo;
import com.natwest.authenticationapi.model.Natwestdb;

@Service
public class NatwestdbServiceImp implements NatwestdbService{

	@Autowired
	private NatwestdbRepo natRepo;
	
	public NatwestdbServiceImp()
	{
		
	}
	
	@Override
	public Natwestdb findByIdAndPassword(String id, String password) {
		// TODO Auto-generated method stub
		return natRepo.findByIdAndPassword(id, password);
	}

	

}
