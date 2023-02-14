package com.stackroute.main;

import java.util.Scanner;
import java.util.Set;

import com.stackroute.dao.CustomerRepoImpl;
import com.stackroute.model.Customer;

public class CustomerMain {
	
	public static void main(String[] args) {
		
		CustomerRepoImpl cRepo = new CustomerRepoImpl();
		
		int option=0;
		Scanner sc = new Scanner(System.in);
		
		do {
			CustomerMain.menu();
			option = sc.nextInt();
			
			switch(option) {
				
			case 1:
				
				System.out.println("Enter id:");
				int tempid = sc.nextInt();
				
				System.out.println("Enter name:");
				String cname = sc.next();
				
				System.out.println("Enter email:");
				String email = sc.next();
				
				System.out.println("Enter phnoe no:");
				String pno = sc.next();
				
				Customer temp = new Customer(tempid, cname, email, pno);
				
				cRepo.addCustomer(temp);
				System.out.println(temp);
				
				break;
			
			case 2:
				System.out.println("Enter the customer id that needs to be deleted:");
				int deleteId = sc.nextInt();
				
				cRepo.deleteCustomer(deleteId);
				break;
				
			case 3:
				cRepo.display();
				break;
				
			case 4:
				System.out.println("Enter record to be updated");
				int cid = sc.nextInt();
				cRepo.update(cid);
				break;
			case 5:
				System.out.println("Enter the record to be searched");
				int cid1 = sc.nextInt();
				cRepo.findCustomer(cid1);
				break;
			default:
				System.out.println("Invalid input");
				break;
				
			}
			
		} while(option!=0);
	}
	
	public static void menu() {
		System.out.println("MENU");
		System.out.println("Press 1: Adding a record");
		System.out.println("Press 2: Deleting a record");
		System.out.println("Press 3: Displaying the record");
		System.out.println("Press 4: Updating the record");
		System.out.println("Press 5: Searching the record");
		System.out.println("Press 0: To exit");
		System.out.println("Enter your selection:");
		
	}
}
