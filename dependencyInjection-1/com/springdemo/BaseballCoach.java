package com.springdemo;

public class BaseballCoach implements Coach {
	
	//dependency
	private FortuneService fortuneService;
	
	//injection of dependency
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}








