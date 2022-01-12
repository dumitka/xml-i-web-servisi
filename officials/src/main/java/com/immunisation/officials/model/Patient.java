package com.immunisation.officials.model;

import java.util.List;

import com.immunisation.officials.model.confirmation.VaccineConfirmation;
import com.immunisation.officials.model.consent.PartForPatients;
import com.immunisation.officials.model.green_certificate.DigitalGreenCertificate;
import com.immunisation.officials.model.interest.Interest;
import com.immunisation.officials.model.request.RequestDigitalGreenCertificate;
import com.immunisation.officials.model.types.ExtendUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends ExtendUser{
	private LoginData loginData;
	private List<RequestDigitalGreenCertificate> requestDigitalGreenCertificate;
	private List<DigitalGreenCertificate> digitalGreenCertificates;
	private List<Interest> requestsVaccination;
	private List<PartForPatients> vaccinationConsents;
	private List<VaccineConfirmation> vaccineConfirmations;
}
