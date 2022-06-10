package com.immunisation.mailer.controller;

import com.immunisation.mailer.model.MailPackage;
import com.immunisation.mailer.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {
	
	@Autowired
	private MailService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> sendEmail(@RequestBody MailPackage content) {
		try {
			System.out.println("EVOOO ZAHTEV_____________________________________________________________");
			service.sendEmail(content.getRecipient().trim(), content.getSubject().trim(), content.getBody().trim());
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
