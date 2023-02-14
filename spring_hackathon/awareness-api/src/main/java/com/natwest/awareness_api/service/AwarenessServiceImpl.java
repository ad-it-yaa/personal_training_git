package com.natwest.awareness_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.natwest.awareness_api.dao.AwarenessRepo;
import com.natwest.awareness_api.model.Awareness;

@Service
public class AwarenessServiceImpl implements AwarenessService{

	@Autowired
	private AwarenessRepo awarRepo;
	
	@Override
	public Awareness addlink(Awareness obj) {
		// TODO Auto-generated method stub
		return awarRepo.save(obj);
	}

	@Override
	public List<Awareness> getawlink() {
		// TODO Auto-generated method stub
		return awarRepo.findAll(Sort.by(Sort.Direction.ASC,"sno"));
	}

	@Override
	public void deleteawlink(int id) {
		// TODO Auto-generated method stub
		awarRepo.deleteById(id);
	}

}
