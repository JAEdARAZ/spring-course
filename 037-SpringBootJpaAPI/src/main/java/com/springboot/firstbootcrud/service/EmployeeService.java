package com.springboot.firstbootcrud.service;

import java.util.List;

import com.springboot.firstbootcrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
}
