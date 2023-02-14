package com.nwmortgage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Register {

	@Id
	private int custid;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String password;
	private String gender;
	private String dob;
	private int card_number;
	private String expiry;
	private String registeredAt;
	private String modifiedAt;
	private String pin;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int custid, String name, String address, String phone, String email, String password, String gender,
			String dob, int card_number, String expiry, String registeredAt, String modifiedAt, String pin) {
		super();
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.card_number = card_number;
		this.expiry = expiry;
		this.registeredAt = registeredAt;
		this.modifiedAt = modifiedAt;
		this.pin = pin;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getCard_number() {
		return card_number;
	}
	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(String registeredAt) {
		this.registeredAt = registeredAt;
	}
	public String getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
