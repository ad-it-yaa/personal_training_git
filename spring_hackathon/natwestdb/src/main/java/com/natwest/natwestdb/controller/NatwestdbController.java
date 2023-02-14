package com.natwest.natwestdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.natwestdb.exception.userexist;
import com.natwest.natwestdb.model.Natwestdb;
import com.natwest.natwestdb.service.NatwestdbService;

@RestController
@RequestMapping("api/natwestdb/")
@CrossOrigin()
public class NatwestdbController {

	private NatwestdbService Natdbservice;
	@Autowired
	public NatwestdbController(NatwestdbService Natdbservice)
	{
		super();
		this.Natdbservice = Natdbservice;
	}
	
	@GetMapping("/get")
		public ResponseEntity<?> getuser()
	{
		List<Natwestdb> userdata = Natdbservice.getuser();
		return new ResponseEntity<List<Natwestdb>>(userdata,HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<?>  userlist(@PathVariable String Id, @RequestBody Natwestdb natdb)
	{
		List<Natwestdb> userdata = Natdbservice.userlist(Id);
		return new ResponseEntity<List<Natwestdb>>(userdata,HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> adduser(@RequestBody Natwestdb add) throws userexist
	{
		try {
			Natdbservice.adduser(add);
			return new ResponseEntity<Natwestdb>(add,HttpStatus.ACCEPTED);
		}
		catch (userexist msg)
		{
			return new ResponseEntity<String>(msg.getMessage(),HttpStatus.CONFLICT);
			
		}
	}
	
	}
