package com.stackroute.dao;

import com.stackroute.model.Customer;

public interface CustomerRepo {
	
	public void addCustomer(Customer c);
	public boolean findCustomer(int cid);
	public void deleteCustomer(int cid);
	public Customer getCustomer(int cid);
	public void update(int cid);
	
	public void display();

}
