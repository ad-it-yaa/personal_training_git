package com.natwest.adapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.natwest.adapi.dao.AdvertisementRepo;
import com.natwest.adapi.model.Advertisement;

@Service
public class AdvertisementServiceImpl implements AdvertusementService{

	@Autowired
	private AdvertisementRepo adrepo;
	
	@Override
	public Advertisement addAd(Advertisement ad) {
		// TODO Auto-generated method stub
		return adrepo.save(ad);
	}

	@Override
	public List<Advertisement> getad() {
		// TODO Auto-generated method stub
		return adrepo.findAll(Sort.by(Sort.Direction.ASC,"sno"));
	}

	@Override
	public void deleteAd(int id) {
		// TODO Auto-generated method stub
		adrepo.deleteById(id);
	}
	
	

}
