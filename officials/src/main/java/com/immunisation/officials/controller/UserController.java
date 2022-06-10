package com.immunisation.officials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.officials.dto.UserDto;
import com.immunisation.officials.dto.UserTokenState;
import com.immunisation.officials.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
//	@GetMapping(path = "/consent", produces=MediaType.APPLICATION_XML_VALUE)
//	public ResponseEntity<List<UserDto>> getUsersWithConsent() {
//		
//		String username = request.getUsername().trim();
//		String password = request.getPassword().trim();
//		
//		UserTokenState token = userService.tryLogin(username, password);
//		
//		return new ResponseEntity<>(token, HttpStatus.OK);
//	}
}
