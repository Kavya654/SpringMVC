package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;
			InstructorDetail in = session.get(InstructorDetail.class, id);
			
			System.out.println("deleting both instrutr and instructr detail");
			
			in.getInstructor().setInstructorDetail(null);
			
			session.delete(in);
			
			System.out.println("deleted both");

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
