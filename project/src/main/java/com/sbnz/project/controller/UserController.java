package com.sbnz.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.project.DTOs.RegistrationDTO;
import com.sbnz.project.model.User;
import com.sbnz.project.security.JwtTokenUtil;
import com.sbnz.project.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody RegistrationDTO regDTO){
		User u = null;
		try {
			u = userService.register(regDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(u.getUsername(), HttpStatus.CREATED);
	}
}
