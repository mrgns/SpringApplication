package com.spring.SpringApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.SpringApplication.entity.RoleMatser;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMatser, Integer> {

}
