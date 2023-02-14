package com.natwest.loginapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.natwest.loginapi.dao.Loginrepo;
import com.natwest.loginapi.model.Natwestdb;

@Service
public class Loginserviceimp implements Loginservice {
	
	@Autowired
	private Loginrepo loginrepo;
	
	public Loginserviceimp()
	{
		
	}

	@Override
	public List<Natwestdb> getuser() {
		// TODO Auto-generated method stub
		return loginrepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
	}




}
