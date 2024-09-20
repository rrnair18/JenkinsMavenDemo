package com.deloitte.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
			
			//CRUD OPERATIONS
//			session.find(null, employees);
//			session.save(employees);
//			session.update(employees);
//			session.remove(employees);
			
			for (Employee emp : employees) {
				System.out.println(emp);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}