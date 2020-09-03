package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage(Model model) {
		
		model.addAttribute("homePage", "Spring MVC Demo - Home Page");
		model.addAttribute("helloWorldForm", "Hello World form");
		
		return "main-menu";
	}
	
}
