package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean
		TennisCoach myCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		//print workout
		System.out.println(myCoach.getDailyWorkout());
		
		//print fortune
		System.out.println(myCoach.getDailyFortune());
		
		//print email
		System.out.println(myCoach.getEmail());

	}

}
