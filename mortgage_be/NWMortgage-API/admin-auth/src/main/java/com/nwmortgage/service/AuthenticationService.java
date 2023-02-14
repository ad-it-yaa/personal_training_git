package com.nwmortgage.service;

import com.nwmortgage.model.Admin;

public interface AuthenticationService 
{
	public Admin findByEmpidAndPassword(int custid, String password);

	public Admin findByEmpid(int custid);
	
}
