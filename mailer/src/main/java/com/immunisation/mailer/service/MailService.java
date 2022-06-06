package com.immunisation.mailer.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender emailSender; //mozda drugacije autowire-ovati?
	
	@Async
	public Future<SimpleMailMessage> sendEmail(String recipient, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipient);
		message.setSubject(subject);
		message.setText(content);
		
		emailSender.send(message);
		return new AsyncResult<>(message);
	}
	
}
