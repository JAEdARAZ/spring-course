package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//this is a class to hold the declarations of poincuts to be used by other aspects (which hold the advices)

@Aspect
public class AOPExpressions {

	//Printed when any method of the DAO package is called
	@Pointcut("execution( void com.aopdemo.dao.*.*(..) )")
	public void forEveryDAO() {}
	
	//Printed when add methods are called
	@Pointcut("execution( void com.aopdemo.dao.*.add*(..) )")
	public void justAddMethod() {}
	
}
