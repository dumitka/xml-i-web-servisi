package com.immunisation.officials.model.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.tipovi.Address;
import com.immunisation.officials.model.tipovi.GeneralUser;

@XmlRegistry
public class ObjectFactory {
	public ObjectFactory() {}
	
	public DigitalGreenCertificate createDigitalGreenCertificate() {
		return new DigitalGreenCertificate();
	}
	
	public CertificateInfo createCertificateInfo() {
		return new CertificateInfo();
	}
	
	public Address createAddress() {
		return new Address();
	}
	
	public GeneralUser createGeneralUser() {
		return new GeneralUser();
	}
	
	public VaccinationInfo createVaccinationInfo() {
		return new VaccinationInfo();
	}
	
	public Vaccination createVaccination() {
		return new Vaccination();
	}
}
