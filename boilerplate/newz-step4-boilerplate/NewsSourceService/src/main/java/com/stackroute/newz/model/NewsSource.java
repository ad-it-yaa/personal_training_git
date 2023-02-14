package com.stackroute.newz.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

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
	 * 
	 * The data type for sourceCreationDate field should be LocalDateTime. 
	 * Please add @JsonSerialize(using = ToStringSerializer.class) for this field
	 */
	
	private int sourceId;
	private String sourceName;
	private String sourceDesc;
	private String sourceCreatedBy;
	private LocalDateTime sourceCreationDate;
	
	
	public NewsSource(int sourceId, String sourceName, String sourceDesc, String sourceCreatedBy,
			LocalDateTime sourceCreationDate) {
		
	}


	public NewsSource() {
	}


	public int getSourceId() {
		return 0;
	}


	public void setSourceId(int sourceId) {
		
	}


	public String getSourceName() {
		return null;
	}


	public void setSourceName(String sourceName) {
		
	}


	public String getSourceDesc() {
		return null;
	}


	public void setSourceDesc(String sourceDesc) {
		
	}


	public String getSourceCreatedBy() {
		return null;
	}


	public void setSourceCreatedBy(String sourceCreatedBy) {
		
	}


	public LocalDateTime getSourceCreationDate() {
		return null;
	}


	public void setSourceCreationDate(LocalDateTime sourceCreationDate) {
		
	}


}
