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
public class PartForPatients {
	private Patient patient;
	private Vaccine vaccine;
	private boolean patientAgrees;
	private LocalDateTime date;  //datum saglasnosti
}
