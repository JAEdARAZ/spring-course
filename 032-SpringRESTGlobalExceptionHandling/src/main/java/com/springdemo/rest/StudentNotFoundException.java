package com.springdemo.rest;

//create our own exception that extends the RuntimeException
public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

}
