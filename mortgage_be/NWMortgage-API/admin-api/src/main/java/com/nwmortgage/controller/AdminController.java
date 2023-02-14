package com.nwmortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Admin;

import com.nwmortgage.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	private AdminService service;

	@Autowired
	public AdminController(AdminService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<?> saveUser(@RequestBody Admin user) throws UserAlreadyExists {

		Admin user1;
		try {
			user1 = service.addUser(user);
			return new ResponseEntity<Admin>(user1, HttpStatus.ACCEPTED);

		} catch (UserAlreadyExists e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/get")
	public ResponseEntity<List<Admin>> getUserList() {
		List<Admin> users = service.userList();
		return new ResponseEntity<List<Admin>>(users, HttpStatus.OK);
	}

	@GetMapping("/get/{empid}")
	public ResponseEntity<?> getCustomerById(@PathVariable int empid) throws UserNotFound {
		try {
			Admin customer = service.getByEmpid(empid);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (UserNotFound e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update/{custid}")
	public ResponseEntity<?> updateUser(@PathVariable int custid, @RequestBody Admin user) throws UserNotFound {
		try {
			Admin obj = service.getByEmpid(custid);
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			obj.setPassword(bcrypt.encode(user.getPassword()));

			service.updateUser(obj);
			return new ResponseEntity<String>("Password Updated", HttpStatus.ACCEPTED);
		} catch (UserNotFound e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
