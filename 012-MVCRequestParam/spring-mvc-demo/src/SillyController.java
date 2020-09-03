package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class SillyController {

	@RequestMapping("/processForm")
	//we can avoid accessing the servlet object by retrieving the attribute using spring
	public String processFormV3 (
			@RequestParam("studentName") String studentName, Model model) {
		
		studentName = studentName.toUpperCase();
		studentName = "Hey " + studentName + " this is V3 boy!";
		
		model.addAttribute("message", studentName);
		
		return "helloworld";
		
	}
	
}
