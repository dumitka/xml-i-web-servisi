package com.immunisation.officials.model.consent;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.Patient;
import com.immunisation.officials.model.types.Address;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {}
	
	public ConsentForVaccination createConsentForVaccination() {
		return new ConsentForVaccination();
	}
	
	public PartForPatients createPartForPatients() {
		return new PartForPatients();
	}
	
	public Patient createPatient() {
		return new Patient();
	}
	
	public PartForPublicOfficial createPartForPublicOfficial() {
		return new PartForPublicOfficial();
	}
	
	public ReceivedVaccine createReceivedVaccine() {
		return new ReceivedVaccine();
	}
	
	public Address createAddress() {
		return new Address();
	}
}
