package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		//wraps a JDBC connection - save and retrieve objects (short-lived object)
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("Flying Planes course");
			tempCourse.addReview(new Review("i liked it a lot"));
			tempCourse.addReview(new Review("it was a fantastic course"));
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
		}
		catch (Exception e){ 
			e.printStackTrace();
		} 
		finally {
			session.close();
			factory.close();
		}
		
	}

}
