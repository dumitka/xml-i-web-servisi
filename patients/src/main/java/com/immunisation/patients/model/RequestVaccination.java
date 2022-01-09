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
public class RequestVaccination {
	private Patient patient;
	private Contact contact;
	private VaccinationData vaccinationData;
	private LocalDateTime date; //datum interesovanja
}
