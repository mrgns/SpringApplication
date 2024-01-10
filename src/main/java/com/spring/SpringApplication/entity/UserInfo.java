package com.spring.SpringApplication.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {

	private String userId;
	private String username;
	private String password;
	private String roles;
	private Collection<? extends GrantedAuthority> authorities;

	public UserInfo(EmployeeMaster emp) {
		this.userId = emp.getUserID();
		this.username = emp.getFirstName()+" "+emp.getLastName();
		this.password = emp.getPassword();
		this.roles = emp.getRoles().getEmployeeRole();
		this.authorities = Collections.singletonList(new SimpleGrantedAuthority(roles));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userId.toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
