package com.springboot.thymeleafdemo.service;

import java.util.List;

import com.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee theEmployee);
	
	public void delete(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
