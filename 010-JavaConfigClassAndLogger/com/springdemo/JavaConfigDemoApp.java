package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from container
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		
		System.out.println(">> " + swimCoach.getDailyWorkout());
		System.out.println(">> " + swimCoach.getDailyFortune());
		
		context.close();
	}

}
