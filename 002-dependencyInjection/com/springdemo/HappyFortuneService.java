package com.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Jhon today is your lucky day mate!";
	}

}
