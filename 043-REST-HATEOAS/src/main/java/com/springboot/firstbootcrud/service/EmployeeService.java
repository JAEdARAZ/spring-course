package com.springboot.firstbootcrud.service;

import java.util.List;

import com.springboot.firstbootcrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee theEmployee);
	
	public void delete(Employee theEmployee);
	
}
