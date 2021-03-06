package com.immunisation.officials.model.report;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {}
	
	public Report createReport() {
		return new Report();
	}
	
	public Period createPeriod() {
		return new Period();
	}
	
	public VaccineDosesForReport createVaccineDosesForReport() {
		return new VaccineDosesForReport();
	}
	
	public Manufacturer createManufacturer() {
		return new Manufacturer();
	}
}
