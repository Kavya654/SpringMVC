package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("janvi", "roy", "janvi@gmail.com");

			InstructorDetail tempInstrucorDetail = new InstructorDetail("http://www.janvi.com", "actress");

			tempInstructor.setInstructorDetail(tempInstrucorDetail);

			session.beginTransaction();

			session.save(tempInstructor);

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
