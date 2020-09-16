package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		//just created once, and then sessions are created out of it
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		//wraps a JDBC connection - save and retrieve objects (short-lived object)
		Session session = factory.getCurrentSession();
		
		try {
			//create instructor and instructorDetail
			Instructor theInstructor = new Instructor("Jaime", "Aran", "jaime@mail.com");
			InstructorDetail theDetail = new InstructorDetail("youtubejaime.com", "biking");
			
			//associate theDetail to theInstructor
			theInstructor.setInstructorDetail(theDetail);
			
			session.beginTransaction();
			//saves theDetail because the relation with entity InstructorDetail is defined as cascade=CascadeType.ALL
			session.save(theInstructor);
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
	}

}
