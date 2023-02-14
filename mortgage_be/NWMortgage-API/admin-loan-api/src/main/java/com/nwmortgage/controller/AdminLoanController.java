package com.nwmortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwmortgage.model.Loan;
import com.nwmortgage.service.AdminLoanService;

@CrossOrigin
@RestController
@RequestMapping("/nwml/api/loan")
public class AdminLoanController 
{

	@Autowired
	private AdminLoanService service;
	
	@Autowired
	public AdminLoanController(AdminLoanService service)
	{
		super();
		this.service = service;
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
		obj.setLoantenure(application.getLoantenure());
		obj.setUpdatedbyemp(application.getUpdatedbyemp());
		obj.setCurrentstatus(application.getCurrentstatus());
		obj.setInterest(application.getInterest());
		obj.setOfferamt(application.getOfferamt());
		obj.setAcceptance(application.getAcceptance());
		service.updateUser(obj);	
		return new ResponseEntity<String>("Status Updated",HttpStatus.ACCEPTED);
	}
}
	
	

