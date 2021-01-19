package com.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		theEmployees = new ArrayList<>();
		
		theEmployees.add(new Employee(1, "Laura", "Lopes", "lau@mail.com"));
		theEmployees.add(new Employee(1, "Mark", "Jones", "mark@mail.com"));
		theEmployees.add(new Employee(1, "Luke", "Ferdinad", "luke@mail.com"));
	}
	
	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		theModel.addAttribute("listEmployees", theEmployees);
		
		return "list-employees";
	}
	
}
