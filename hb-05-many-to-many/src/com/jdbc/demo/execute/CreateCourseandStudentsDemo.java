package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;
import com.jdbc.demo.entity.Review;
import com.jdbc.demo.entity.Student;

public class CreateCourseandStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			
			//create course 
			Course tempCourse = new Course("sanskrit");
			
			System.out.println("course : " + tempCourse);
			//save the course
			session.save(tempCourse);
			
			//create students
			Student stu1 = new Student("kavya","anusha","khavya@luv2code.com");
			Student stu2 = new Student("akhil","narayan","anusha@gmail.com");
			
			//add students to course
			tempCourse.addStudent(stu1);
			tempCourse.addStudent(stu2);
			
			System.out.println("students : " + tempCourse.getStudents());
			
			
			//save the students
			session.save(stu1);
			session.save(stu2);



			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
