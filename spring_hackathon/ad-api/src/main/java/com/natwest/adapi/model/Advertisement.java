package com.natwest.adapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Advertisement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int sno;
	String url;
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Advertisement(int sno, String url) {
		super();
		this.sno = sno;
		this.url = url;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
