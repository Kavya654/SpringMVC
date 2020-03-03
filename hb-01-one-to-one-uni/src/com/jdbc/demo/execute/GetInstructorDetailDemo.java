package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 5;
			InstructorDetail in = session.get(InstructorDetail.class, id);
			
			System.out.println("instructor detail " +in);
			System.out.println("associated instructor " +in.getInstructor());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
