package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateDeleteStudentDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		try {
			//--------------------UPDATE--------------------
			//wraps a JDBC connection - save and retrieve objects (short-lived object)
			Session session = factory.getCurrentSession();
			
			//id we know exists (just for practise) and get student
			int idStudent = 1;
			session.beginTransaction();
			Student retrievedStudent = session.get(Student.class, idStudent);

			//changing retrieved object will update without need of session.update or similar, just by commit
			retrievedStudent.setLastName("López");
			session.getTransaction().commit();
			
			//update all emails using HQL
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='test@gmail.com'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			//--------------------DELETE--------------------
			//once the object is retrieved, it can be deleted with the method
			//session.delete(retrieveStudent); 
			
			//delete using HQL 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2")
					.executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
	}

}
