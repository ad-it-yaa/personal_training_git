package com.nwmortgage.exception;

public class UserAlreadyExists extends Exception{
	
	public UserAlreadyExists() {}
	
	public UserAlreadyExists(String msg)
	{
		super(msg);
	}
	

}
