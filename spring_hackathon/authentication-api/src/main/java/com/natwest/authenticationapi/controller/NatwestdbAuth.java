package com.natwest.authenticationapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.authenticationapi.model.Natwestdb;
import com.natwest.authenticationapi.service.NatwestdbService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@CrossOrigin
public class NatwestdbAuth {
	
	@Autowired
	private NatwestdbService natService;
	static final long timeout = 1000*60*60;
	
	Map<String, String> keyvalue = new HashMap<>();
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody Natwestdb user)
	{
		try {
			String token = generateToken(user.getId(), user.getPassword());
			keyvalue.clear();
			keyvalue.put("token", token);
			return new ResponseEntity<Map<String,String>>(keyvalue,HttpStatus.ACCEPTED);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			keyvalue.clear();
			keyvalue.put("message", e.getMessage());
			return new ResponseEntity<Map<String,String>>(keyvalue,HttpStatus.UNAUTHORIZED);
		}
		
	
	}
	
	public String generateToken(String id, String pass) throws ServletException
	{
	
		if(id==" " && pass ==" ")
		{
			throw new ServletException("Please fill the username and password field");
		}
		else
		{
			Natwestdb temp = natService.findByIdAndPassword(id, pass);
		
					if(temp == null)
					{
						throw new ServletException("Incorrect Credentials, Please try again");						
					}
					String token = Jwts.builder()
							.setSubject(id)
							.setIssuedAt(new Date())
							.setExpiration(new Date(System.currentTimeMillis()+timeout))
							.signWith(SignatureAlgorithm.HS256, "mysecretkey")
							.compact();
		return token;
				

				}
	
	
	}

}
