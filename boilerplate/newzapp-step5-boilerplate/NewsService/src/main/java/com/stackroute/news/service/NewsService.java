package com.stackroute.news.service;

import java.util.List;

import com.stackroute.news.model.News;
import com.stackroute.news.util.exception.NewsNotFoundExeption;

public interface NewsService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	boolean addNews(News news);

	boolean deleteNews(String userId, int newsId);

	boolean deleteAllNews(String userId) throws NewsNotFoundExeption;

	News updateNews(News news, int id, String userId) throws NewsNotFoundExeption;

	News getNewsByNewsId(String userId, int newsId) throws NewsNotFoundExeption;

	List<News> getAllNewsByUserId(String userId);

}
