package com.natwest.adapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.adapi.model.Advertisement;
import com.natwest.adapi.service.AdvertusementService;

@RestController
@RequestMapping("/api/ads")
@CrossOrigin
public class AdvertisementController {
	
	@Autowired
	private AdvertusementService adservice;
	
	@GetMapping("/get")
	public ResponseEntity<?> getad() {
		List<Advertisement> adlist = adservice.getad();
		return new ResponseEntity<List<Advertisement>>(adlist,HttpStatus.OK);
		
	}
	@PostMapping("/add")
	
		public ResponseEntity<Advertisement> addAd(@RequestBody Advertisement ad)
		{
		adservice.addAd(ad);
		return new ResponseEntity<Advertisement>(ad,HttpStatus.CREATED);
		}
	
}
