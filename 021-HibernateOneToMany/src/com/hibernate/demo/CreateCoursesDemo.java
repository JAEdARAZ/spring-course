package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		//wraps a JDBC connection - save and retrieve objects (short-lived object)
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//hardcoded id
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("Hiking Course");
			Course tempCourse2 = new Course("Mountain Bike Course");
			
			tempCourse1.setInstructor(tempInstructor);
			tempCourse2.setInstructor(tempInstructor);
			
			/* ALTERNATIVE WAY OF DOING IT
			//since the instructor is created already, we need to add the new courses to the list
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			*/
			
			//then save those courses in the course table
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
