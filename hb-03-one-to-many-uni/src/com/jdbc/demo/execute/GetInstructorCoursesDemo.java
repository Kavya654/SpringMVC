package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {



			session.beginTransaction();
			
			int id = 2;
			Instructor inst = session.get(Instructor.class, id);

		System.out.println("instructor is : "+inst);
		
		System.out.println("Courses under instructor are : "+inst.getCourses());

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
