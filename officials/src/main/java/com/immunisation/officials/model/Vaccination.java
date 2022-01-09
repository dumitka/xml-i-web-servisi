package com.immunisation.officials.model;

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
public class Vaccination {
	private Vaccine type;
	private String manufacturer;
	private String series;
	private String healthFacility;
	private int dose;
}
