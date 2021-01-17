package com.springboot.firstbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.firstbootcrud.entity.Employee;
import com.springboot.firstbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{theId}")
	public Employee getEmployee(@PathVariable int theId){
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee == null) {
			throw new RuntimeException("not found employee with id " + theId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {
		//make sure that the id does not exist so the body is saved
		theEmployee.setId(0);
		return employeeService.save(theEmployee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee == null) {
			throw new RuntimeException("not found employee with id " + theId);
		}
		
		employeeService.delete(theEmployee);
		return "The employee with id " + theId + " has been deleted";
	}
}
