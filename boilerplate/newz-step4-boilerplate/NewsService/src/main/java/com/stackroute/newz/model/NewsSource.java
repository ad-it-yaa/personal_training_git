package com.stackroute.newz.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * The class "NewsSource" will be acting as the data model. 
 */
public class NewsSource {
	/*
	 * 
	 * Out of these fields, the
	 * field sourceId should be the key. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 */
	
	private String sourceId;
	private String sourceName;
	
	
	public NewsSource(String sourceId, String sourceName) {
		
	}


	public NewsSource() {
		
	}


	public String getSourceId() {
		return null;
	}


	public void setSourceId(String sourceId) {
		
	}


	public String getSourceName() {
		return null;
	}


	public void setSourceName(String sourceName) {
		
	}


	
	
}
