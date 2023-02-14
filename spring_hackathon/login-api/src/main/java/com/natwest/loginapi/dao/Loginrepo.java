package com.natwest.loginapi.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.loginapi.model.Natwestdb;

@Repository
public interface Loginrepo extends CrudRepository<Natwestdb, String> {

	Natwestdb findByIdAndPassword(String id, String password);

	List<Natwestdb> findAll(Sort by);

}
