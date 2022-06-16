package com.java.sprinboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.java.sprinboot.model.Employee;
import com.java.sprinboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	 @Autowired
	 private EmployeeRepository employeeRepository ;
	 
	 //get all employees
	 @GetMapping("/employees")
	 public List<Employee> getAllEmployees(){
		 return employeeRepository.findAll();
	 }
	 
	 //create employee rest api
	 @PostMapping("/employees")
	 public Employee createEmployee(@RequestBody Employee emloyee) {
		 return employeeRepository.save(emloyee) ;
	 }
	 
	 //get employee by id rest api
	 @GetMapping("/employees/{id}")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElse(null);
		 return ResponseEntity.ok(employee);
		 
	 }
	 
	 // 
}
