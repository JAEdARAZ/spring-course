package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCoursesToStudentDemo {

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
				
			//hardcoded id
			int theId = 1;
			Query<Student> query = 
					session.createQuery("select s from Student s "
								+ "JOIN FETCH s.courses "
								+ "where s.id=:theStudentId",
								Student.class);
			
			query.setParameter("theStudentId", theId);
			//better performance than session.get() since that would need to retrieve later the courses to add the new one
			//since it would check that it's not repeated, for example (unique title)
			Student theStudent = query.getSingleResult();
			
			Course theCourse = new Course("Spinning course");

			session.save(theCourse);
			theStudent.addCourse(theCourse);
			
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
