package com.deloitte.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDemo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Add a new employee: ");
        	System.out.println("Enter name:");
        	String name = sc.next();
        	System.out.println("Enter salary: ");
        	double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			
			session.beginTransaction();

			session.save(employee);
			
			System.out.println("Done");
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
		
			factory.close();
		}
		
	}
	
}

