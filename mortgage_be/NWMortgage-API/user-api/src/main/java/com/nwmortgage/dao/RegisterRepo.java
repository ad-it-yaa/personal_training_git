package com.nwmortgage.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nwmortgage.model.Register;

@Repository
public interface RegisterRepo extends CrudRepository<Register, Integer>{
	
}
