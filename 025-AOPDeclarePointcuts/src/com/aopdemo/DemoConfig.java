package com.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //so spring can use Spring AOP
@ComponentScan("com.aopdemo")
public class DemoConfig {
	
}
