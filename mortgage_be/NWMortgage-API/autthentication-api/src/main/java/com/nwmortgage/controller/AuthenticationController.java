package com.nwmortgage.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nwmortgage.model.Register;
import com.nwmortgage.service.AuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
@ComponentScan({ "com.nwmortgage.service.AuthenticationService*" })
@RestController
@CrossOrigin
public class AuthenticationController {
	
	
	
	@Autowired
	private AuthenticationService authservice;
	
	static final long timeout = 1000*60*60;
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	Map<String,String> keyvalue = new HashMap<>();
	
	
	@PostMapping("/login")	
	public ResponseEntity<?> authenticate(@RequestBody Register user)
	{
		
		
		try {
			String token = generateToken(user.getCustid(), user.getPassword());
			keyvalue.clear();
			keyvalue.put("token", token);
			keyvalue.put("cid", Integer.toString(user.getCustid()));
			return new ResponseEntity<Map<String,String>>(keyvalue,HttpStatus.ACCEPTED);
		} catch (ServletException e) {
			keyvalue.clear();
			keyvalue.put("message", e.getMessage());
			return new ResponseEntity<Map<String,String>>(keyvalue,HttpStatus.UNAUTHORIZED);
		}
		
	}
	public String generateToken(int custid, String pass) throws ServletException
	{
	
		if(custid==0 && pass ==" ")
		{
			throw new ServletException("Please fill the customer id and password field");
		}
		else
		{
			Register temp = authservice.findByCustid(custid);
			
			
		
					if(temp != null && bcrypt.matches(pass,temp.getPassword()))
					{
						String token = Jwts.builder()
								.setSubject(Integer.toString(custid))
								.setIssuedAt(new Date())
								.setExpiration(new Date(System.currentTimeMillis()+timeout))
								.signWith(SignatureAlgorithm.HS256, "mysecretkey")
								.compact();
								return token;
										
					}
					else
					{
						throw new ServletException("Incorrect Credentials, Please try again");				
					}
				

				}
	
	
	}

}
