package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.User;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 2;
			User user = session.get(User.class,id);
			
			user.setFirstName("kavya");
			
			session.getTransaction().commit();
			System.out.println("done");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<User> users) {
		for (User s : users) {
			System.out.println(s);
		}
	}
}