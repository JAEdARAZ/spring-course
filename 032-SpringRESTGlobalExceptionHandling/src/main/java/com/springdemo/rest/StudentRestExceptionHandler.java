package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//global exception handler so the exceptions can be reached from any rest controller
//the methods could be in the controller (SpringRestController), but this is the good practice
@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add an exception handler for StudentNotFoundException
		//studentErrorResponse is the type of response body when we catch StudentNotFoundException
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			//create StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value()); //it's 404
			error.setMessage(exc.getMessage()); //we set it when we throw the exception
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		//for the rest of exceptions, passing a string instead of an int 
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value()); //400 
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	
}
