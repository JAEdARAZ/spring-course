package com.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message=">=0")
	@Max(value=10, message="<=10")
	private Integer freeCoupons;

	@CourseCode(value={"COD", "VAL"}, message="starts with COD or VAL")
	private String courseCode;
	

	public Customer() {}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreeCoupons() {
		return freeCoupons;
	}

	public void setFreeCoupons(Integer freeCoupons) {
		this.freeCoupons = freeCoupons;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
