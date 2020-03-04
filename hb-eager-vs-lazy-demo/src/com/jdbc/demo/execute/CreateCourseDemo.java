package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			//create an instructor

			int id = 3;
			Instructor inst = session.get(Instructor.class, id);

			//create some courses
			
			Course c1 = new Course("acting");
			Course c2 = new Course("fashion");
			
			
			//add course to instructor
			inst.add(c1);
			inst.add(c2);
			

			//save the course
			session.save(c1);
			session.save(c2);
			
			
			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
