package com.springboot.firstbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.firstbootcrud.entity.Employee;

//this will give the crud methods out of the box, no need for implementation
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
