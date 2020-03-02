package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 4;
			Instructor in = session.get(Instructor.class, id);
			
			if (in != null) {
			session.delete(in);
			System.out.println("deleted");
			}

			session.getTransaction().commit();
			System.out.println("already deleted");

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
