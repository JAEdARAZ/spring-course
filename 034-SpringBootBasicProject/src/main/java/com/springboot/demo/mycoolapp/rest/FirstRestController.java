package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

	@GetMapping("/")
	public String hello() {
		return "Hi there, first Spring Boot Project!!";
	}
	
}
