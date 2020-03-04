package com.jdbc.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jdbc.demo.entity.Course;
import com.jdbc.demo.entity.Instructor;
import com.jdbc.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;
			
			//add a query with HQL
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " 
													+ "JOIN FETCH i.courses "
													+ "where i.id=:theInstructorId",Instructor.class);
			
			query.setParameter("theInstructorId", id);

			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println(tempInstructor);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("session is closed");
			
			System.out.println(tempInstructor.getCourses());
			
			System.out.println("lazy loading hql solution done");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
