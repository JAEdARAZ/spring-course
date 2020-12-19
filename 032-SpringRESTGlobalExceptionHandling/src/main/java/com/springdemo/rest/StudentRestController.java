package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void populateStudentsList() {
		students = new ArrayList<>();
		students.add(new Student("Jonny", "Perez"));
		students.add(new Student("Lucrecio", "Kravitz"));
		students.add(new Student("Kat", "Jones"));
	}

	//get all the students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	//retrieve student by id
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		//throw our customized exception in case the id is out of bounds
		if( studentId >= students.size() || studentId<0 ) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}
		
		return students.get(studentId);
	}
	
}
