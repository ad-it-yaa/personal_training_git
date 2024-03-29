package com.stackroute.newz.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/*
 * The class "UserProfile" will be acting as the data model for the UserProfile Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

public class UserProfile {
	/*
	 * This class should have six fields
	 * (newsId,firstName,lastName, contact,createAt,newsList). 
	 * Out of these six fields, the
	 * field newsId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 * annotate newsList field with @OneToMany and add
	 * @JsonIgnore annotation.
	 * 
	 * The data type for createAt field should be LocalDateTime. 
	 * Please add @JsonSerialize(using = ToStringSerializer.class) for this field
	 */
	

	
	
	
	public UserProfile(String userId, String firstName, String lastName, String contact, LocalDateTime createAt,
			List<News> newsList) {
	
		
	}

	public UserProfile() {
		
	}

	
	public String getContact() {
		return null;
	}

	
	public void setContact(String contact) {
		
	}

	
	public LocalDateTime getCreateAt() {
		return null;
	}

	
	public void setCreateAt(LocalDateTime createAt) {
		
	}

	
	public String getUserId() {
		return null;
	}

	
	public void setUserId(String userId) {
		
	}

	
	public String getFirstName() {
		return null;
	}

	
	public void setFirstName(String firstName) {
		
	}

	
	public String getLastName() {
		return null;
	}

	
	public void setLastName(String lastName) {
		
	}

	

}
