package com.springboot.firstbootcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.firstbootcrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	//EntityManager (JPA object that wraps the Hibernate Session)
	private EntityManager entityManager;
	
	//constructor injection (any other type of injection could be used)
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		//get Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//query to retrieve data
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		return theQuery.getResultList();
	}

}
