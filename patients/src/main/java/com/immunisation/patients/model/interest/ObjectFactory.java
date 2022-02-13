package com.immunisation.patients.model.interest;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.patients.model.types.Contact;
import com.immunisation.patients.model.types.GeneralUser;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {}
	
	public Interest createRequestVaccination() {
		return new Interest();
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
