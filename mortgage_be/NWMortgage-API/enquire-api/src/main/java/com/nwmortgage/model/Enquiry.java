package com.nwmortgage.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enquiry {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	int sno;
	String name;
	String address;
	String phoneno;
	String email;
	String message;
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enquiry(int sno, String name, String address, String phoneno, String email, String message) {
		super();
		this.sno = sno;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.message = message;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
