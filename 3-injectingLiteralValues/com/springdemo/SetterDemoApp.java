package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//print the coach's daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//print - from a literal value injection (applicationContext.xml)
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		context.close();
	}

}
