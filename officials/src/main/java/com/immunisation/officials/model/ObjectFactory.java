package com.immunisation.officials.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	 public ObjectFactory() {}
	 
	 // RequestVaccination
	 public RequestVaccination createRequestVaccination() {
		return new RequestVaccination();
	 }
	 
	 public GeneralUser createPatient() {
		 return new GeneralUser();
	 }
	 
	 public Contact createContact() {
		 return new Contact();
	 }
	 
	 public VaccinationData createVaccinationData() {
		 return new VaccinationData();
	 }
	 
	 // Report
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
