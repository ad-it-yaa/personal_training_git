package com.nwmortgage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nwmortgage.model.Register;

@Repository
public interface AuthenticationRepo extends CrudRepository<Register, Integer>
{

	public Register findByCustidAndPassword(int custid, String password);

	public Register findByCustid(int custid);
	
}
