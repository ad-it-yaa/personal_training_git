package com.natwest.loginapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.loginapi.model.Natwestdb;
import com.natwest.loginapi.service.Loginservice;


@RestController
@RequestMapping("api/natwestdb")
public class Logincontroller {

	@Autowired
	private Loginservice loginservice;
	
	@GetMapping("/get")
		public ResponseEntity<?> getuser()
	{
		List<Natwestdb> userdata = loginservice.getuser();
		return new ResponseEntity<List<Natwestdb>>(userdata,HttpStatus.OK);
	}	
	
	}
