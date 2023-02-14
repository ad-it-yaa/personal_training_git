package com.stackroute.dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.stackroute.model.Customer;

public class CustomerRepoImpl implements CustomerRepo {
	Scanner sc = new Scanner(System.in);
	ArrayList<Customer> customerlist; 
	
	
	public CustomerRepoImpl() {
		customerlist = new ArrayList<Customer>();
	}

	@Override
	public void addCustomer(Customer c) {
		if(!findCustomer(c.getCid())) {
			customerlist.add(c);
		} else {
			System.out.println("Record already exist");
		}
		
	}

	@Override
	public boolean findCustomer(int cid) {
		for(Customer c:customerlist ) {
			if(c.getCid() == cid) {
				System.out.println(c);
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteCustomer(int cid) {
		
		Customer customertodelete = null;
		
		for(Customer c : customerlist) {
			if(c.getCid() == cid) {
				customertodelete = c;
			}
		}
		
		if(customertodelete == null) {
			System.out.println("Record does not exist, delete not possible");
		} else {
			customerlist.remove(customertodelete);
		}
		
	}

	@Override
	public Customer getCustomer(int cid) {
		return null;
		// TODO Auto-generated method stub
		

	}

	@Override
	public void update(int cid) {

		
		
		
		Boolean result =true;

		for(Customer c : customerlist) {
			System.out.println("For block executed");
			if(c.getCid() == cid) {
				
				{
					System.out.println("Enter name");
					c.setCname(sc.next());
					System.out.println("Enter email");
					c.setEmail(sc.next());
					System.out.println("Enter phoneno");
					c.setPno(sc.next());
					System.out.println("Records updated");
					System.out.println("Updated data" + c.getCid() + " " + c.getCname() + " " + c.getEmail() + " " + c.getPno());
				}
					
					break;
				
			}
			

			else {
				result = false;
			} 
						
		}
		if(!result)
		{

			System.out.println("Record does not exist, update not possible");		
			
		}
				
	}
	
	@Override
	public void display() {
		if(customerlist.isEmpty()) {
			System.out.println("No records available");
		} else {
			for(Customer cust:customerlist) {
				System.out.println(cust.toString());
			}
		}
		
	}
	
	

}
