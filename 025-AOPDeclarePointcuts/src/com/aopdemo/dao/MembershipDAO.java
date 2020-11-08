package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void updateMembership(String param) {
		System.out.println(getClass() + ": update a MEMBERSHIP, do something in DB");
	}
	
}
