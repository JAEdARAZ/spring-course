package com.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
//this class is where advices are located
public class MyDemoLoggingAspect {
	
	@Before("com.aopdemo.aspect.AOPExpressions.forEveryDAO()")
	public void beforeDAOMethods(JoinPoint theJoinPoint) {
		System.out.println("========> Executing @Before advice to ANY METHOD");
		
		//to print the name of the metod that triggers this advice
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//print the parameters of the method
		Object[] args = theJoinPoint.getArgs();
		for(Object arg :args) {
			System.out.println("arg: " + arg.toString());
		}
	}
	
	
	@Before("com.aopdemo.aspect.AOPExpressions.forEveryDAO() && com.aopdemo.aspect.AOPExpressions.justAddMethod()") //just to show that poincuts work as boolean operations
	public void beforeAdd() {
		System.out.println("========> Executing @Before advice to ADD METHODS");
	}
	
}
