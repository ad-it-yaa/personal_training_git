package com.stackroute.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.news.model.UserNews;

/*
* This class is implementing the MongoRepository interface for Note.
* Annotate this class with @Repository annotation
* */

public interface NewsRepository extends MongoRepository<UserNews, String> {

}
