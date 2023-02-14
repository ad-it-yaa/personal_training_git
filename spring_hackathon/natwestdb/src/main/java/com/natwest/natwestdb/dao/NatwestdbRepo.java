package com.natwest.natwestdb.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.natwestdb.model.Natwestdb;

@Repository
public interface NatwestdbRepo extends CrudRepository<Natwestdb, String>{

	List<Natwestdb> findAll(Sort by);
	

}
