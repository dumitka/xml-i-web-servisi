package com.immunisation.officials.model.interesovanje;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.tipovi.Contact;
import com.immunisation.officials.model.tipovi.GeneralUser;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {}
	
	public RequestVaccination createRequestVaccination() {
		return new RequestVaccination();
	}
	
	public VaccinationData createVaccinationData() {
		return new VaccinationData();
	}
	
	public GeneralUser createGeneralUser() {
		return new GeneralUser();
	}
	
	public Contact createContact() {
		return new Contact();
	}
}
