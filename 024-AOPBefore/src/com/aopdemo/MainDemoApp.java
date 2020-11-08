package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		account.addAccount();
		
		MembershipDAO membership = context.getBean("membershipDAO", MembershipDAO.class);
		membership.addMembership(new String("param"));
		
		context.close();
	}

}
