package com.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleafdemo.entity.Employee;

//this will give the crud methods out of the box, no need for implementation
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//sort employees by last name - Spring Data JPA parses the method name to know how to sort
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
