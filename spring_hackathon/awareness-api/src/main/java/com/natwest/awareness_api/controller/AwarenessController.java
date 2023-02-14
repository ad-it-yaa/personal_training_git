package com.natwest.awareness_api.controller;

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

import com.natwest.awareness_api.model.Awareness;
import com.natwest.awareness_api.service.AwarenessService;

@RestController
@RequestMapping("/api/awareness")
@CrossOrigin
public class AwarenessController {

	@Autowired
	private AwarenessService awService;
	
	@GetMapping("/get")
	public ResponseEntity<?> getawlink()
	{
		List<Awareness> awlist = awService.getawlink();
		return new ResponseEntity<List<Awareness>>(awlist,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Awareness> addlink(@RequestBody Awareness aw)
	{
		awService.addlink(aw);
		return new ResponseEntity<Awareness>(aw,HttpStatus.ACCEPTED);
	}
	
}
