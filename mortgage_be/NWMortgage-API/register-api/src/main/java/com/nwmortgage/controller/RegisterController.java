package com.nwmortgage.controller;


import java.util.List;
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
import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Register;
import com.nwmortgage.service.RegisterService;


@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	private RegisterService service;
	
	@Autowired
	public RegisterController(RegisterService service)
	{
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveUser(@RequestBody Register user) throws UserAlreadyExists
	{
		
		Register user1;
		try
		{
			user1 = service.addUser(user);
			return new ResponseEntity<Register>(user1,HttpStatus.ACCEPTED);
			
		} catch(UserAlreadyExists e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Register>> getUserList() {
		List<Register> users = service.userList();
		return new ResponseEntity<List<Register>>(users,HttpStatus.OK);
	}
	
	 @GetMapping("/get/{custid}")
	 public ResponseEntity<?> getCustomerById(@PathVariable int custid) throws UserNotFound 
	 {
		 try {
			 Register customer = service.getByCustid(custid);
			    return new ResponseEntity<>(customer, HttpStatus.OK);
		 }
		 catch(UserNotFound e)
			{
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
			} 
	 }
	 @PostMapping("/checkpin")
	 public ResponseEntity<?> checkPin(@RequestBody Register user) throws UserNotFound {
		 try
		 {
		     Register dbUser = service.getByCustid(user.getCustid());
		     BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		     Boolean isMatch = bcrypt.matches(user.getPin(), dbUser.getPin());
		     return new ResponseEntity<Boolean>(isMatch, HttpStatus.OK);
		 }
		 catch(UserNotFound e)
			{
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
			} 
	 }
	
	@PutMapping("/update/{custid}")
	public ResponseEntity<?> updateUser(@PathVariable int custid, @RequestBody Register user) throws UserNotFound {
		try {
			Register obj = service.getByCustid(custid); 
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			obj.setPassword(bcrypt.encode(user.getPassword()));
			obj.setModifiedAt(user.getModifiedAt());
			service.updateUser(obj);		
			return new ResponseEntity<String>("Password Updated",HttpStatus.ACCEPTED);
		}
		 catch(UserNotFound e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} 
	}

}
