package com.nwmortgage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nwmortgage.model.Admin;
 

@Repository
public interface AuthenticationRepo extends CrudRepository<Admin, Integer>
{

	public Admin findByEmpidAndPassword(int empid, String password);

	public Admin findByEmpid(int empid);
	
}
