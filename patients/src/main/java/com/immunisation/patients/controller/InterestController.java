package com.immunisation.patients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.service.InterestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
@RequestMapping(value = "api/patient/interest", produces = MediaType.APPLICATION_XML_VALUE)
public class InterestController {
	
	
	@Autowired
	private InterestService service;
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE) //produces?
	public ResponseEntity<Object> getAll() {
		try {
			InterestCollection collection = service.getAll();
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while getting Interests", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> saveInterest(@RequestBody String interest) {
		try {
			service.saveInterest(interest);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
