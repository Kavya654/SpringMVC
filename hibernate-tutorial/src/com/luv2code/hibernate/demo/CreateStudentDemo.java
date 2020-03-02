package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.User;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			System.out.println("creating a student object");

			//Create operation
			//create a student
			User user = new User("daffy", "om", "mary@luv2code.com");

			//start transaction
			session.beginTransaction();

			//save it to database
			session.save(user);
			
			//commit the save 
			session.getTransaction().commit();
			
			//read a user.comment above and run to execute below code
			
			session.beginTransaction();
			
			int id = 1;
			
			User us = session.get(User.class, id);
			
			System.out.println(us);
			
			session.getTransaction().commit();
			
			System.out.println("done");

		} finally {
			factory.close();
		}
	}
}