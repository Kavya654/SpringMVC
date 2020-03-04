package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 3;
			Instructor inst = session.get(Instructor.class, id);

			System.out.println("luv2 code instructor is : " + inst);

			//to avoid exception,before closing the session do get courses
			
			System.out.println("luv 2 code Courses under instructor are : " + inst.getCourses());
			

			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("session is closed");
			
			//since courses are lazy loaded this should fail
			
			System.out.println("luv 2 code Courses under instructor are : " + inst.getCourses());
			
			System.out.println("luv 2 code done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
