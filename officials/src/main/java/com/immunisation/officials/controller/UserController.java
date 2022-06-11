package com.immunisation.officials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.officials.dto.UserCollection;
import com.immunisation.officials.service.ConsentForVaccinationService;
import com.immunisation.officials.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ConsentForVaccinationService cfvService;
	
	@GetMapping(path = "/consent", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserCollection> getPatientsWithConsent() throws Exception {
		UserCollection collection = service.getPatientsWithConsent(cfvService.getJmbgs());
		return new ResponseEntity<UserCollection>(collection, HttpStatus.OK);
	}
}
