package com.immunisation.patients.model.consent;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.patients.model.types.Address;
import com.immunisation.patients.model.types.ExtendUser;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {}
	
	public ConsentForVaccination createConsentForVaccination() {
		return new ConsentForVaccination();
	}
	
	public PartForPatients createPartForPatients() {
		return new PartForPatients();
	}
	
	public ExtendUser createPatient() {
		return new ExtendUser();
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
