package com.immunisation.patients.model;


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
public class DigitalGreenCertificate {
	private Header header;
	private Patient patient;
	private VaccinationInfo vaccinationInfo;
	private CertificateInfo certificateInfo;
	private TestInfo test;
}
