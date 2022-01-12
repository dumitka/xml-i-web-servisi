package com.immunisation.officials.model.potvrda;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.Patient;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {}
	
	public VaccineConfirmation createReport() {
		return new VaccineConfirmation();
	}
	
	public Patient createPatient() {
		return new Patient();
	}
	
	public VaccineDoses createVaccineDoses() {
		return new VaccineDoses();
	}
	
	//Vaccine
}
