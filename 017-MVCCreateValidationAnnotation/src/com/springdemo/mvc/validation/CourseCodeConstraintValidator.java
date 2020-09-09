package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String>{
	
	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		//get default values or the ones defined in Customer.class
		coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext CourseCode) {
		
		boolean result = false;

		//find out if theCode starts with COD or VAL
		if(theCode != null) {
			for (String tempPrefix : coursePrefixes) {
				if(theCode.startsWith(tempPrefix)) {
					result = true;
					break;
				}
			}
		}
		else {
			result = true;
		}
		
		return result;
	}

}
