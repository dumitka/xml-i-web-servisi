package com.immunisation.officials.model.saglasnost;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {}
	
	public ConsentForVaccination createConsentForVaccination() {
		return new ConsentForVaccination();
	}
	
	public PartForPatients createPartForPatients() {
		return new PartForPatients();
	}
	
	public PartForPublicOfficial createPartForPublicOfficial() {
		return new PartForPublicOfficial();
	}
}
