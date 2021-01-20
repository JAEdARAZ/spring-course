package com.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		theModel.addAttribute("listEmployees", employeeService.findAll());
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		theModel.addAttribute("employee", new Employee());
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee theEmployee) {
		employeeService.save(theEmployee);
		
		//--> post/redirect/get pattern, so the user cannot load more than one user by refreshing
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		theModel.addAttribute("employee", employeeService.findById(theId));
		
		return "employees/employee-form";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	
}
