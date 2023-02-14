package com.nwmortgage.service;

import java.util.List;

import com.nwmortgage.model.Loan;

public interface AdminLoanService {

	public List<Loan> applicationlist();
	public Loan updateUser(Loan application);
	public Loan getByloanid(int loanid);
	public Loan getBycustid(int custid);
	

}
