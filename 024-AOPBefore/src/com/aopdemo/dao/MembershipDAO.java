package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMembership(String param) {
		System.out.println(getClass() + ": add a MEMBERSHIP, do something in DB");
	}
	
}
