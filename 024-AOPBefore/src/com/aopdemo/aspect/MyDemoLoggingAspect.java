package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
//this class is where advices are located
public class MyDemoLoggingAspect {
	
	//use of wildcards (*) to match any add method, (..) independent of num of params
	@Pointcut("execution( void com.aopdemo.dao.*.add*(..) )")
	private void pointcutVar() {}

	//Before POINTCUT, specifies where the advice is applied
	@Before("pointcutVar()")
	public void beforeAddAccountAdvice() {
		System.out.println("========> Executing @Before advice - Add Method");
	}
	
}
