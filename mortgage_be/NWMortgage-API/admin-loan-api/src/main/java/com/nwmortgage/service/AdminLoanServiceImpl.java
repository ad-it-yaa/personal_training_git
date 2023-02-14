package com.nwmortgage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwmortgage.dao.AdminLoanRepo;
import com.nwmortgage.model.Loan;

@Service
public class AdminLoanServiceImpl implements AdminLoanService {

	@Autowired
	private AdminLoanRepo loanrepository;
	
	@Override
	public List<Loan> applicationlist() {
		List<Loan> applicationlist = (List<Loan>) loanrepository.findAll();
		return applicationlist;
	}

	@Override
	public Loan updateUser(Loan application) {
		Loan values = loanrepository.save(application);   
		return values;
	}

	@Override
	public Loan getByloanid(int loanid) {
		return loanrepository.findByLoanid(loanid).get();
	}

	@Override
	public Loan getBycustid(int custid) {
		return loanrepository.findById(custid).get();
	}



}
