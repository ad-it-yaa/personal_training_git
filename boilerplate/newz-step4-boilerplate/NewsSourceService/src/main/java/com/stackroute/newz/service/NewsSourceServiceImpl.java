package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.repository.NewsSourceRepository;
import com.stackroute.newz.util.exception.NewsSourceAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;

/*
 * This class is implementing the NewsService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */
@Service
public class NewsSourceServiceImpl implements NewsSourceService {
	
	/*
	 * Autowiring should be implemented for the NewsSourceRepository.
	 */
	

	/*
	 * Add a new newsSource. Throw NewsSourceAlreadyExistsException if the news source with specified
	 * sourceId already exists.
	 */
	public NewsSource addNewsSource(NewsSource newsSource) throws NewsSourceAlreadyExistsException {
		
		return null;
	}

	
	/*
	 * Delete an existing news source by it's sourceId. Throw NewsSourceNotFoundException if the 
	 * news source with specified sourceId does not exist.
	 */
	public void deleteNewsSource(int sourceId) throws NewsSourceNotFoundException {
		
		
		
	}

	/*
	 * Update an existing news source by it's sourceId. Throw NewsSourceNotFoundException if the 
	 * news source with specified sourceId does not exist.
	 */
	public NewsSource updateNewsSource(NewsSource newsSource, int sourceId) throws NewsSourceNotFoundException {
		return null;
	}

	/*
	 * Retrieve an existing news source by it's sourceId. Throw NewsSourceNotFoundException if the 
	 * news source with specified sourceId does not exist.
	 */
	public NewsSource getNewsSourceById(int sourceId) throws NewsSourceNotFoundException {
		
		return null;
	}

	/*
	 * Retrieve all existing news source
	 */
	public List<NewsSource> listAllNewsSources() {
		
		return null;
	}

}
