package com.immunisation.officials.model;

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
public class PartForPublicOfficial {
	private String healthFacility;
	private LocalDateTime dateOfVaccination;
	private String wayOfGivingTheVaccine;
	private String limb;
	private String vaccineSeries;
	private String manufacturer;
	private String sideEffect;
	private String temporaryContractions; //privremene kontrakcije
	private String permanentContractions;
}
