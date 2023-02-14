package com.nwmortgage.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.nwmortgage.model.Enquiry;
 
import com.nwmortgage.service.RegisterService;


@RestController
@RequestMapping("/api/enquiry")
@CrossOrigin
public class RegisterController {
	
	private RegisterService service;
	
	@Autowired
	public RegisterController(RegisterService service)
	{
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveUser(@RequestBody Enquiry user)  
	{
		
		Enquiry user1;
 
		{
			user1 = service.addUser(user);
			return new ResponseEntity<Enquiry>(user1,HttpStatus.ACCEPTED);
			
		}  
		 
	
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Enquiry>> getUserList() {
		List<Enquiry> users = service.userList();
		return new ResponseEntity<List<Enquiry>>(users,HttpStatus.OK);
	}
	
	 @GetMapping("/get/{custid}")
	 public ResponseEntity<?> getCustomerById(@PathVariable int sno)  
	 {
	 
		 Optional<Enquiry> customer = service.getBySno(sno);
			    return new ResponseEntity<>(customer, HttpStatus.OK);
		 
	 }
 
//	@PutMapping("/update/{custid}")
//	public ResponseEntity<?> updateUser(@PathVariable int custid, @RequestBody Register user) throws UserNotFound {
//		try {
//			Register obj = service.getByCustid(custid); 
//			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//			obj.setPassword(bcrypt.encode(user.getPassword()));
//			obj.setModifiedAt(user.getModifiedAt());
//			service.updateUser(obj);		
//			return new ResponseEntity<String>("Password Updated",HttpStatus.ACCEPTED);
//		}
//		 catch(UserNotFound e)
//		{
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//		} 
//	}

}
