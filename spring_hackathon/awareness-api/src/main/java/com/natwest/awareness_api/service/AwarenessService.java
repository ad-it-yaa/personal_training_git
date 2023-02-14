package com.natwest.awareness_api.service;

import java.util.List;

import com.natwest.awareness_api.model.Awareness;

public interface AwarenessService {
	
	public Awareness addlink(Awareness a);
	public List<Awareness> getawlink();
	public void deleteawlink(int id);
	
}
