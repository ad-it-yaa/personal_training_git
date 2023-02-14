package com.nwmortgage.service;

import java.util.List;

import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Admin;
 


public interface AdminService {
	
	public Admin addUser(Admin user) throws UserAlreadyExists;
	public List<Admin> userList();
	public Admin updateUser(Admin user);
	public Admin getByEmpid(int custid) throws UserNotFound;

}
