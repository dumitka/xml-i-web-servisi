package com.immunisation.officials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.officials.dto.ConsentCollection;
import com.immunisation.officials.dto.ConsentHWPart;
import com.immunisation.officials.dto.VaccineDto;
import com.immunisation.officials.service.ConsentService;

@RestController
@RequestMapping(value = "api/consents", produces = MediaType.APPLICATION_XML_VALUE)
public class ConsentController {
	@Autowired
	private ConsentService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getAll() {
		try {
			ConsentCollection collection = service.getAllUnfinishedConsents();
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while getting vaccineInfos", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
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
	
	
	@PostMapping(value="/confirm", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> confirm(@RequestBody String confirm) {
		try {
			service.saveConfirmFromString(confirm);
			System.out.println("TACA");
			System.out.println(confirm);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
