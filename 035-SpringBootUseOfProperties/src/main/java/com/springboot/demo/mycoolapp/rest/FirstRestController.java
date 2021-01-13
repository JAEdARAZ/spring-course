package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

	@Value("${hello.world}")
	private String helloWorld;
	
	@GetMapping("/")
	public String hello() {
		return helloWorld;
	}
	
}
