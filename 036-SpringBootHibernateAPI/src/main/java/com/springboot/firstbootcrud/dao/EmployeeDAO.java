package com.springboot.firstbootcrud.dao;

import java.util.List;

import com.springboot.firstbootcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
