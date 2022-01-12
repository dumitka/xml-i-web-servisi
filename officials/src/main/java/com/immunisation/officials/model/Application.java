package com.immunisation.officials.model;

import java.util.List;

import com.immunisation.officials.model.confirmation.VaccineConfirmation;
import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.model.green_certificate.DigitalGreenCertificate;
import com.immunisation.officials.model.interest.Interest;
import com.immunisation.officials.model.report.Report;
import com.immunisation.officials.model.request.RequestDigitalGreenCertificate;

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
	private List<Interest> requestVaccination;
	private List<VaccineConfirmation> vaccineConfirmations;
	private List<ConsentForVaccination> consentForVaccination;
	private List<WhenWhereVaccine> whenWhereVaccine;
	private List<Report> report;
	
	
}
