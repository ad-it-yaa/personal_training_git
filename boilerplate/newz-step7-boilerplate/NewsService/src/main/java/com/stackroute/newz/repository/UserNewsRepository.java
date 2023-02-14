package com.stackroute.newz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.newz.model.UserNews;

/*
* This class is implementing the MongoRepository interface for UserNews.
* Annotate this class with @Repository annotation
* 
*/

public interface UserNewsRepository  extends MongoRepository<UserNews, String>{

	
}
