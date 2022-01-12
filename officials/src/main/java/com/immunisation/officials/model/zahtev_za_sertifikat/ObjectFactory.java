package com.immunisation.officials.model.zahtev_za_sertifikat;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.tipovi.GeneralUser;

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
