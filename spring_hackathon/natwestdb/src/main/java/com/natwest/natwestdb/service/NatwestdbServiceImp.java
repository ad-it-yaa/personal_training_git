package com.natwest.natwestdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.natwest.natwestdb.dao.NatwestdbRepo;
import com.natwest.natwestdb.exception.userexist;
import com.natwest.natwestdb.model.Natwestdb;

@Service
public class NatwestdbServiceImp implements NatwestdbService {
	
	@Autowired
	private NatwestdbRepo NatRepo;

	@Override
	public Natwestdb adduser(Natwestdb obj) throws userexist {
		// TODO Auto-generated method stub
		Optional<Natwestdb> user = NatRepo.findById(obj.getId());
		if(user.isPresent())
		{
			throw new userexist("User already exist!");
		}
		else
		{
		return NatRepo.save(obj);
		}
	}
	@Override
	public List<Natwestdb> getuser() {
		// TODO Auto-generated method stub
		return NatRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
	}

	@Override
	public void deleteuser(String id) {
		// TODO Auto-generated method stub
		NatRepo.deleteById(id);
		
	}
	@Override
	public  List<Natwestdb> userlist(String id) {
		// TODO Auto-generated method stub
		return (List<Natwestdb>) NatRepo.findById(id).get();
	}

	}
	


