package com.immunisation.patients.controller;

import com.immunisation.patients.dto.JwtAuthenticationRequest;
import com.immunisation.patients.dto.RegistrationRequest;
import com.immunisation.patients.dto.UserTokenState;
import com.immunisation.patients.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;

	
	//login i signup
	@PostMapping(path = "/signup", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> signUp(@RequestBody RegistrationRequest data) {
		
		userService.createNewUser(data);
		
		return new ResponseEntity<>(HttpStatus.OK); //ne vracamo usera, nije potrebno?
	}
	
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_XML_VALUE , produces =MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserTokenState> loginAndCreateToken(@RequestBody JwtAuthenticationRequest request) {
		
		String username = request.getUsername().trim();
		String password = request.getPassword().trim();
		
		UserTokenState token = userService.tryLogin(username, password);
		
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
}
