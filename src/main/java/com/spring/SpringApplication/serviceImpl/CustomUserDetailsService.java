package com.spring.SpringApplication.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.SpringApplication.entity.EmployeeMaster;
import com.spring.SpringApplication.entity.UserInfo;
import com.spring.SpringApplication.entity.Users;
import com.spring.SpringApplication.repository.EmployeeMasterRepository;
import com.spring.SpringApplication.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<EmployeeMaster> emp =  employeeMasterRepository.findByUserID(username);
		return emp.map(UserInfo :: new).orElseThrow(()-> new UsernameNotFoundException("Username is not found "+username));
	}

}
