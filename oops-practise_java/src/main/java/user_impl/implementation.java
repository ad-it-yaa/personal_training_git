package user_impl;

import java.util.Scanner;

import user_Model.employee;
import user_Repo.Methods;

public class implementation implements Methods
{
	
	Scanner sc;
	employee emp;
	
	public implementation()
	{
	
		sc = new Scanner(System.in);		
		emp = new employee();
	}

	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID:");
		emp.setEmp_id(sc.nextInt());
		System.out.println("Enter Name:");
		emp.setName(sc.next());
		System.out.println("Enter Email:");
		emp.setEmail(sc.next());
		System.out.println("Enter Ph.no:");
		emp.setPhone(sc.next());
		
	}

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("User successfully added!");
		System.out.println("ID: " +emp.getEmp_id() + " Name: " + emp.getName() + " Email: " + emp.getEmail() + " Phone: " + emp.getPhone());
		
		
	}
	
	

}
