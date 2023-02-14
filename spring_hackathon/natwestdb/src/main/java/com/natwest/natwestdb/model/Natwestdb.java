package com.natwest.natwestdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Natwestdb {
@Id
String id;
String name;
String address;
String account;
String phone;
String password;
int card;
double amount;
public Natwestdb() {
	super();
	// TODO Auto-generated constructor stub
}
public Natwestdb(String id, String name, String address, String account, String phone, String password,
		int card, double amount) {
	super();
	this.id = id;

	this.name = name;
	this.address = address;
	this.account = account;
	this.phone = phone;
	this.password = password;
	this.card = card;
	this.amount = amount;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getCard() {
	return card;
}
public void setCard(int card) {
	this.card = card;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}
