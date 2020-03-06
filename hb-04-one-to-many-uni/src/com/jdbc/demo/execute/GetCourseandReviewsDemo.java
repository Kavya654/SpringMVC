package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;
import com.jdbc.demo.entity.Review;

public class GetCourseandReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id =10;
			Course cou = session.get(Course.class, id);
			
			System.out.println("course : " + cou);
			
			System.out.println("course : " + cou.getReviews());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
