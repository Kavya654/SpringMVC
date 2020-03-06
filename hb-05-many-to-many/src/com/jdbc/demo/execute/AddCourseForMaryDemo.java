package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;
import com.jdbc.demo.entity.Review;
import com.jdbc.demo.entity.Student;

public class AddCourseForMaryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 5;
			Student stud = session.get(Student.class, id);

			System.out.println("student : " + stud + "student courses : " + stud.getCourses());

			Course c1 = new Course("python");
			Course c2 = new Course("flask");

			c1.addStudent(stud);
			c2.addStudent(stud);

			session.save(c1);
			session.save(c2);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
