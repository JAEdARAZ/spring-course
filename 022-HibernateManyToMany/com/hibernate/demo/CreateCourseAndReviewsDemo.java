package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//wraps a JDBC connection - save and retrieve objects (short-lived object)
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			Course theCourse = new Course("Tennis technique course");
			Student theStudent1 = new Student("Charles", "Doe", "charlesdoe@mail.com");
			Student theStudent2 = new Student("Jane", "Doessa", "janedoessa@mail.com");
			
			theCourse.addStudent(theStudent1);
			theCourse.addStudent(theStudent2);
			
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theCourse);
			
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
