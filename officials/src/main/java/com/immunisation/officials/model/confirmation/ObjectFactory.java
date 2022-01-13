package com.immunisation.officials.model.confirmation;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.types.GeneralUser;

@XmlRegistry
public class ObjectFactory {
	public ObjectFactory() {}
	
	public VaccineConfirmation createVaccineConfirmation() {
		return new VaccineConfirmation();
	}
	
	public GeneralUser createGeneralUser() {
		return new GeneralUser();
	}
	
	public VaccineDoses createVaccineDoses() {
		return new VaccineDoses();
	}
}
