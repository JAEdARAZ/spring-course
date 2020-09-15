package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateReadStudentDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//wraps a JDBC connection - save and retrieve objects (short-lived object)
		Session session = factory.getCurrentSession();
		
		try {
			//add student
			Student student = new Student("Manuel", "Cardona", "manu@mail.com");
			session.beginTransaction();
			int idStudent = (int) session.save(student);
			session.getTransaction().commit();
			
			//new session and get student that has been added
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrievedStudent = session.get(Student.class, idStudent);
			session.getTransaction().commit();

			System.out.println(retrievedStudent.toString());
			
		}
		finally {
			factory.close();
		}
		
	}

}
