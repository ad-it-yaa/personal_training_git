package com.stackroute.model;

public class Customer {
	
	private int cid;
	private String cname;
	private String email;
	private String pno;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cid, String cname, String email, String pno) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.pno = pno;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	@Override
	public String toString() {
		return "Customer details: with customer Id: " +cid + ", customer name: " + cname + ", email: " + email + ", phone no: " + pno ;
	}

}
