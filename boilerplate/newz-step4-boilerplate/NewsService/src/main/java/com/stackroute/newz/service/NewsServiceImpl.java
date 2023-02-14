package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.repository.NewsSourceRepository;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsNotFoundException;

/*
 * This class is implementing the NewsService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */

public class NewsServiceImpl implements NewsService {
	
	/*
	 * Autowiring should be implemented for the NewsRepository.
	 */
	
	/*
	 * Autowiring should be implemented for the NewsSourceRepository.
	 */
	

	/*
	 * Add a new news. Throw NewsAlreadyExistsException if the news with specified
	 * newsId already exists.
	 */
	@Override
	public News addNews(News news) throws NewsAlreadyExistsException {
		
		return null;
		
	}

	/*
	 * Update an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	@Override
	public News updateNews(News news) throws NewsNotFoundException {
		
		return null;
	}
	
	/*
	 * Delete an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	@Override
	public void deleteNews(int newsId) throws NewsNotFoundException {
		
		
	}

	/*
	 * Retrieve all existing news
	 */
	@Override
	public List<News> listAllNews() {
		
		return null;
	}

	/*
	 * Retrieve an existing news by it's newsId. Throw NewsNotFoundException if the 
	 * news with specified newsId does not exist.
	 */
	@Override
	public News getNewsById(int newsId) throws NewsNotFoundException {
		
		return null;
	}

	/*
	 * Retrieve an existing news by it's authorName.
	 */
	@Override
	public List<News> listNewsByAuthor(String authorName) {
		
		return null;
	}

	/*
	 * Retrieve an existing news by it's sourceName.
	 */
	@Override
	public List<News> listNewsByNewsSource(String sourceName) {
		
		return null;
	}

}
