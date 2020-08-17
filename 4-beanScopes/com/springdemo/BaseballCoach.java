package com.springdemo;

public class BaseballCoach implements Coach {
	
	//dependency
	private FortuneService fortuneService;
	private String testVariable;
	
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
	
	public void setAttribute (String testVariable) {
		this.testVariable = testVariable;
	}
	
	public String getAttribute () {
		return testVariable;
	}

}








