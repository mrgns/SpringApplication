package com.spring.SpringApplication.apis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringApplication.configs.JwtService;
import com.spring.SpringApplication.serviceImpl.CustomUserDetailsService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtService jwtService;

	public LoginController(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Authentication authenticate = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			String token  = jwtService.generateToken(username);
			map.put("Data", userDetails);
			map.put("Token", token);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
