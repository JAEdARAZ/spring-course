package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	//field dependency injection - with java reflection (even that the attribute is private)
	@Autowired
	@Qualifier("randomFortuneService") //more than one implementation of FortuneService
	private FortuneService fortuneService;
	
	//inject from the properties file
	@Value("${foo.email}")
	private String email;

	public TennisCoach() {}
	
	@Override
	public String getDailyWorkout() {
		return "Practice forehand bro!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
		
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
}
