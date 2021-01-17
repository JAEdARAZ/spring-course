package com.springboot.firstbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.firstbootcrud.entity.Employee;

//this class will give the crud methods out of the box, no need for implementation

//gives the name of the endpoint (app-context/employees)
@RepositoryRestResource(path="employees") 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
