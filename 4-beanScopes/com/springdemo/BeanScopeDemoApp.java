package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//instantiate using bean from the spring container
		BaseballCoach theCoach = context.getBean("myCoach", BaseballCoach.class);
		BaseballCoach alphaCoach = context.getBean("myCoach", BaseballCoach.class);
		
		alphaCoach.setAttribute("perro");
		theCoach.setAttribute("casa");
		
		System.out.println("testVariable alphaCoach: " + alphaCoach.getAttribute());
		System.out.println("testVariable theCoach: " + theCoach.getAttribute());
		
	}
}
