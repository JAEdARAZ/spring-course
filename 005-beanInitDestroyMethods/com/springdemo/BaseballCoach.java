package com.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach, DisposableBean {
	
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
	
	public void doMyStartupThings() {
		System.out.println("Hello from startup things");
	}
	
	//for singleton
	public void doMyClosingThings() {
		System.out.println("Hello from closing things");
	}
	
	//for prototype - needs to override the DisposableBean interface method
	@Override
	public void destroy() throws Exception {
		System.out.println("Hello from closing things");		
	}

}








