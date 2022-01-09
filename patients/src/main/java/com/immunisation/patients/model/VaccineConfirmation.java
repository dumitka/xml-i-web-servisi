package com.immunisation.patients.model;

import java.time.LocalDateTime;

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
public class VaccineConfirmation {
	private VaccineDoses vaccineDoses;
	private String confirmationCode; //sifra potvrde
	private Patient patient;
	private String healthFacility;
	private Vaccine vaccine; //naziv vakcine
	private LocalDateTime dateOfIssue; //datum izdavanja
	private String QRCode;
}
