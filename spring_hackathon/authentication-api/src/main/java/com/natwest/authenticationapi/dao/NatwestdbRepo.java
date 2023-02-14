package com.natwest.authenticationapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.authenticationapi.model.Natwestdb;

@Repository
public interface NatwestdbRepo extends CrudRepository<Natwestdb, String> {

	public Natwestdb findByIdAndPassword(String id, String password);
}
