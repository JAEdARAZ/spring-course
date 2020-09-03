package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan("com.springdemo")
@Import(MyLoggerConfigJavaClass.class)
public class SportConfig {
	
	@Bean
	//the name of the method becomes the id of the Bean
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		//the scope by default is singleton, so sadFortuneService() returns the singleton instance that was created before
		return new SwimCoach(sadFortuneService());
	}
	
}
