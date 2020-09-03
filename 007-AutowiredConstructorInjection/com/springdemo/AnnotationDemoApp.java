package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		//print workout
		System.out.println(myCoach.getDailyWorkout());
		
		//print fortune
		System.out.println(myCoach.getDailyFortune());

	}

}
