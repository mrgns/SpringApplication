package com.spring.SpringApplication.service;

import java.util.List;

import com.spring.SpringApplication.entity.EmployeeMaster;

public interface EmployeeService {

	List<EmployeeMaster> findAll();

	EmployeeMaster findOne(Integer empId);

}
