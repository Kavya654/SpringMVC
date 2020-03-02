package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.User;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<User> users = session.createQuery("from User u where u.firstName='mary' or  u.email like '%luv2code%'").getResultList();
			
			displayStudents(users);

			session.getTransaction().commit();

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