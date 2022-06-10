package com.immunisation.patients.controller;

import java.util.HashMap;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.patients.dto.MailPackage;
import com.immunisation.patients.service.EmailService;
import com.immunisation.patients.service.InterestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "api/interest", produces = MediaType.APPLICATION_XML_VALUE)
public class InterestController {
	
	
	@Autowired
	private InterestService service;
	
	@Autowired 
	private EmailService emailService;
	
	@GetMapping(value = "/hello", produces = MediaType.ALL_VALUE)
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
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
	public ResponseEntity<Object> save(@RequestBody String interest) {
		try {
			service.saveInterestFromString(interest);
			
			
//			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
//		MailPackage mp = emailService.confirmInterestCreation(interestObj);
		
//		HashMap<String, Long> params = new HashMap<>();
//		params.put("userId", orderDetails.getUserId());
//		try {
//		    ResponseEntity<Object> response = new RestTemplate().getForEntity("http://localhost:8080/users/{userId}", MailPackage.class, params);
//		}
//		catch (Exception ex) {
//		    throw new Exception("Mail Not working");
//		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
