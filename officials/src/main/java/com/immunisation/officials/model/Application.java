package com.immunisation.officials.model;

import java.util.List;

import com.immunisation.officials.model.digitalni_sertifikat.DigitalGreenCertificate;
import com.immunisation.officials.model.interesovanje.RequestVaccination;
import com.immunisation.officials.model.izvestaj.Report;
import com.immunisation.officials.model.potvrda.VaccineConfirmation;
import com.immunisation.officials.model.saglasnost.ConsentForVaccination;
import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
	private List<Patient> patients;
	private List<PublicOfficial> publicOfficials;
	private VaccineDataBase vaccineDataBase;
	
	private List<DigitalGreenCertificate> digitalGreenCertificates;
	private List<RequestDigitalGreenCertificate> requestDigitalGreenCertificate;
	private List<RequestVaccination> requestVaccination;
	private List<VaccineConfirmation> vaccineConfirmations;
	private List<ConsentForVaccination> consentForVaccination;
	private List<WhenWhereVaccine> whenWhereVaccine;
	private List<Report> report;
	
	
}
