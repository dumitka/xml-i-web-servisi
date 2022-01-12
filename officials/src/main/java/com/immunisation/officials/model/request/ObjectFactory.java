package com.immunisation.officials.model.request;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.types.GeneralUser;

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
