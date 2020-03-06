package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;
import com.jdbc.demo.entity.Review;
import com.jdbc.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 13;
			Course stud = session.get(Course.class, id);

			session.delete(stud);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
