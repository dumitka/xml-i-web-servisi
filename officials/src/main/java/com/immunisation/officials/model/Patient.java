package com.immunisation.officials.model;

import java.util.List;

import com.immunisation.officials.model.digitalni_sertifikat.DigitalGreenCertificate;
import com.immunisation.officials.model.interesovanje.RequestVaccination;
import com.immunisation.officials.model.potvrda.VaccineConfirmation;
import com.immunisation.officials.model.saglasnost.PartForPatients;
import com.immunisation.officials.model.tipovi.ExtendUser;
import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends ExtendUser{
	private LoginData loginData;
	private List<RequestDigitalGreenCertificate> requestDigitalGreenCertificate;
	private List<DigitalGreenCertificate> digitalGreenCertificates;
	private List<RequestVaccination> requestsVaccination;
	private List<PartForPatients> vaccinationConsents;
	private List<VaccineConfirmation> vaccineConfirmations;
}
