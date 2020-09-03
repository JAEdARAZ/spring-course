package com.springdemo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	} 
	
	@Override
	public String getDailyWorkout() {
		return "swim for 30 minutes boy";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
