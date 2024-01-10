package com.spring.SpringApplication.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringApplication.entity.EmployeeMaster;
import com.spring.SpringApplication.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/greet")
	public String sayHello() {
		return "Welcome to Application";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeMaster>> findAll(){
		return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<EmployeeMaster> getOne(@PathVariable("id") Integer empId){
		return new ResponseEntity<>(employeeService.findOne(empId),HttpStatus.OK);
	}

}
