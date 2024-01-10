package com.spring.SpringApplication.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringApplication.entity.EmployeeMaster;
import com.spring.SpringApplication.repository.EmployeeMasterRepository;
import com.spring.SpringApplication.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMasterRepository employeeMasterRepository;

	@Override
	public List<EmployeeMaster> findAll() {
		try {
			List<EmployeeMaster> findAll = employeeMasterRepository.findAll();
			if(!findAll.isEmpty())
				return findAll;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public EmployeeMaster findOne(Integer empId) {
		try {
			Optional<EmployeeMaster> findById = employeeMasterRepository.findById(empId);
			if(findById.isPresent()) {
				return findById.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
