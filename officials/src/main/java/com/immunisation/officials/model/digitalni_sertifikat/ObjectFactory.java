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
	
	public Header createHeader() {
		return new Header();
	}
	
	public CertificateInfo createCertificateInfo() {
		return new CertificateInfo();
	}
	
	public Publisher createPublisher() {
		return new Publisher();
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
	
	
	public TestInfo createTestInfo() {
		return new TestInfo();
	}
	
	
	public Test createTest() {
		return new Test();
	}
	
	
	public Informations createInformations() {
		return new Informations();
	}
	
	
	public static Results createResults() {
		return new Results();
	}
	
	
	
	
	
}
