package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("moscow", "denver", "rio@gmail.com");

			InstructorDetail tempInstrucorDetail = new InstructorDetail("http://www.youtube.com", "money heist");

			tempInstructor.setInstructorDetail(tempInstrucorDetail);

			session.beginTransaction();

			session.save(tempInstructor);

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
