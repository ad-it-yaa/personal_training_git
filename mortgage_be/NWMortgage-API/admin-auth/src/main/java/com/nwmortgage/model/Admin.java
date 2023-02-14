package com.nwmortgage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private int empid;
	private String password;
	private String empname;
	
	public Admin(int empid, String password, String empname) {
		super();
		this.empid = empid;
		this.password = password;
		this.empname = empname;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	
}
