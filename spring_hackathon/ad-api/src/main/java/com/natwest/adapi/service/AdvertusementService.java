package com.natwest.adapi.service;

import java.util.List;

import com.natwest.adapi.model.Advertisement;

public interface AdvertusementService {

	public Advertisement addAd(Advertisement ad);
	public List<Advertisement> getad();
	public void deleteAd(int id);
	
}
