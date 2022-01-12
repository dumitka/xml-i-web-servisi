package com.immunisation.officials.model.izvestaj;

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
	
	public DistributionOfManufacturer createDistributionOfManufacturer() {
		return new DistributionOfManufacturer();
	}
}
