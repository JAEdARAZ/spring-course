package com.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "this is not a good day matie better stay home";
	}

}
