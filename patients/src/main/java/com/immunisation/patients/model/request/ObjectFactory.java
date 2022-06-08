package com.immunisation.patients.model.request;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.patients.model.types.GeneralUser;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {}
	
	public RequestDigitalGreenCertificate createRequestDigitalGreenCertificate() {
		return new RequestDigitalGreenCertificate();
	}
	
	public GeneralUser createGeneralUser() {
		return new GeneralUser();
	}
}
