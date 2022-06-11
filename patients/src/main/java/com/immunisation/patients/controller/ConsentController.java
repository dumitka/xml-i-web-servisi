package com.immunisation.patients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.patients.service.ConsentService;

@RestController
@RequestMapping(value = "api/consent", produces = MediaType.APPLICATION_XML_VALUE)
public class ConsentController {
	
	@Autowired
	ConsentService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> save(@RequestBody String consent) {
		try {
			service.saveConsentFromString(consent);
			System.out.println("TACA");
			System.out.println(consent);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
