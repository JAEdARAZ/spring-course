package com.springboot.firstbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.firstbootcrud.dao.EmployeeRepository;
import com.springboot.firstbootcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	//@Transactional --> NOT NEEDED, JpaRepository includes this functionality
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		//Optional is introduced in Java 8 to not check for nulls. Used by Spring Data
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		
		return theEmployee;
	}

	//for both save and update
	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(Employee theEmployee) {
		employeeRepository.delete(theEmployee);
	}

}
