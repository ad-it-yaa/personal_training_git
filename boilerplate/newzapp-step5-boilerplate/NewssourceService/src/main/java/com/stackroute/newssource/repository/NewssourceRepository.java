package com.stackroute.newssource.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.newssource.model.Newssource;

/*
* This class is implementing the MongoRepository interface for Note.
* Annotate this class with @Repository annotation
* 
*/
public interface NewssourceRepository extends MongoRepository<Newssource, Integer> {
	List<Newssource> findAllNewssourceByNewssourceCreatedBy(String newssourceCreatedBy);
}
