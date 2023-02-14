package com.nwmortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nwmortgage.model.Loan;
import com.nwmortgage.service.LoanService;


@RestController
@RequestMapping("/api/loan")
public class LoanController 
{
	
	@Autowired
	private LoanService service;
	
	@Autowired
	public LoanController(LoanService service)
	{
		super();
		this.service = service;
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> saveapp(@RequestBody Loan application)
	{
		Loan addapplication = service.addUser(application);
		return new ResponseEntity<Loan>(addapplication,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Loan>> allapplication() {
		List<Loan> application = service.applicationlist();
		return new ResponseEntity<List<Loan>>(application,HttpStatus.OK);
	}
	
	@GetMapping("/get/{loanid}")
    public ResponseEntity<Loan> getCustomerById(@PathVariable int  loanid)  {
		Loan loan = service.getByloanid(loanid);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.CONFLICT);
            		
        }
    }
	@GetMapping("/getcust/{custid}")
    public ResponseEntity<Loan> getCustomerById2(@PathVariable int  custid)  {
		Loan loan = service.getBycustid(custid);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.CONFLICT);
            		
        }
    }
	@PutMapping("/update/{loanid}")
	public ResponseEntity<String> updateUser(@PathVariable int loanid, @RequestBody Loan application) {
		
		Loan obj = service.getByloanid(loanid); 
		obj.setUpdatetime(application.getUpdatetime());
		obj.setStatus(application.getStatus());
		service.updateUser(obj);		
		return new ResponseEntity<String>("Status Updated",HttpStatus.ACCEPTED);
	}
}
