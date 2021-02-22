package com.springboot.firstbootcrud.rest;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	//improved to use HATEOAS
	@GetMapping("/employees/{theId}")
	public EntityModel<Employee> getEmployee(@PathVariable int theId){
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee == null) {
			throw new RuntimeException("not found employee with id " + theId);
		}

		//HATEOAS
		EntityModel<Employee> entity = EntityModel.of(theEmployee);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		entity.add(linkTo.withRel("all-employees"));
		
		return entity;
	}

	//improved, to use 201 Created status
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee savedEmployee = employeeService.save(theEmployee);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() //gets /api/employees
				.path("/{theId}").buildAndExpand(savedEmployee.getId()) //injects the id in {theId}
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employees/{theId }")
	public String deleteEmployee(@PathVariable int theId) {
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee == null) {
			throw new RuntimeException("not found employee with id " + theId);
		}
		
		employeeService.delete(theEmployee);
		return "The employee with id " + theId + " has been deleted";
	}
}
