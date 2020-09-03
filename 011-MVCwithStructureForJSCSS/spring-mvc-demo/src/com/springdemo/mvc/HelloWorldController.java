package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processFormV2(HttpServletRequest request, Model model) {
		
		//read request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		name = "Hey what's up " + name;
		model.addAttribute("message", name);
		
		return "helloworld";
	}
	
}
