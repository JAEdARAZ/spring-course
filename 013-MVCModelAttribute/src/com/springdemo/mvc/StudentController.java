package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student" , student);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	//it's needed to retrieve the attribute from the model to use it in student-confirmation
	public String processStudentForm(@ModelAttribute("student") Student student) {
		
		return "student-confirmation";
	}
	
}
