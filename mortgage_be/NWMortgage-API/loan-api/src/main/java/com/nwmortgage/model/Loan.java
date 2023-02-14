package com.nwmortgage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int loanid;
	private int custid;
	private String applytime;
	private String propertyrate;
	private String loanamt;
	private int loantenure;
	private double income;
	private String occupation;
	private String tin;
	private String address;
	private float interest;
	private String status;
	private String currentstatus; 
	private int creditscore;
	private String updatetime;
	private String updatedbyemp;
	private String offeramt;
	private String acceptance;
	public Loan(int loanid, int custid, String applytime, String propertyrate, String loanamt, int loantenure,
			double income, String occupation, String tin, String address, float interest, String status,
			String currentstatus, int creditscore, String updatetime, String updatedbyemp, String offeramt,
			String acceptance) {
		super();
		this.loanid = loanid;
		this.custid = custid;
		this.applytime = applytime;
		this.propertyrate = propertyrate;
		this.loanamt = loanamt;
		this.loantenure = loantenure;
		this.income = income;
		this.occupation = occupation;
		this.tin = tin;
		this.address = address;
		this.interest = interest;
		this.status = status;
		this.currentstatus = currentstatus;
		this.creditscore = creditscore;
		this.updatetime = updatetime;
		this.updatedbyemp = updatedbyemp;
		this.offeramt = offeramt;
		this.acceptance = acceptance;
	}
	public int getLoanid() {
		return loanid;
	}
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getPropertyrate() {
		return propertyrate;
	}
	public void setPropertyrate(String propertyrate) {
		this.propertyrate = propertyrate;
	}
	public String getLoanamt() {
		return loanamt;
	}
	public void setLoanamt(String loanamt) {
		this.loanamt = loanamt;
	}
	public int getLoantenure() {
		return loantenure;
	}
	public void setLoantenure(int loantenure) {
		this.loantenure = loantenure;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public int getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getUpdatedbyemp() {
		return updatedbyemp;
	}
	public void setUpdatedbyemp(String updatedbyemp) {
		this.updatedbyemp = updatedbyemp;
	}
	public String getOfferamt() {
		return offeramt;
	}
	public void setOfferamt(String offeramt) {
		this.offeramt = offeramt;
	}
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	
	
}
