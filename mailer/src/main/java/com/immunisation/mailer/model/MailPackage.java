package com.immunisation.mailer.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "mailPackage")
@XmlType(propOrder = {"recipient", "subject", "body"})
public class MailPackage {

	private String recipient;
	private String subject;
	private String body;
	
	
	public MailPackage() {
	}
	
	@XmlElement
	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@XmlElement
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@XmlElement
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
