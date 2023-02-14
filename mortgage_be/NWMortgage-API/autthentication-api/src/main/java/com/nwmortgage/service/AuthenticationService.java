package com.nwmortgage.service;
import com.nwmortgage.model.Register;


public interface AuthenticationService 
{
	public Register findByCustidAndPassword(int custid, String password);

	public Register findByCustid(int custid);
	
}
