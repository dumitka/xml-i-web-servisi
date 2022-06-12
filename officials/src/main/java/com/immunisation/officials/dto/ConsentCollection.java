package com.immunisation.officials.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.immunisation.officials.model.consent.ConsentForVaccination;

@XmlRootElement(name = "consent_collection")
public class ConsentCollection {

	@XmlElementWrapper(name="Consents")
	@XmlElement(name="Consent")
	public ConsentForVaccination[] consents;

	public ConsentCollection(ConsentForVaccination[] consents) {
		super();
		this.consents = consents;
	}

	public ConsentCollection() {
		super();
	}
	
	
}
