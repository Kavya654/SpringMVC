package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.User;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;
			User user = session.get(User.class,id);
			session.delete(user);
			
			
			//another method 
			
			
			//session.createQuery("delete from student where id=1").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("done");

		} finally {
			factory.close();
		}
	}
}