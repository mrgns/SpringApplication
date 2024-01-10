package com.spring.SpringApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SpringApplication.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	

}
