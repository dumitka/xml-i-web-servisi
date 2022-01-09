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
public class Report {
	private VaccineDosesForReport vaccineDosesForReport;
	private Period period;
	private DistributionOfManufacturer distributionOfManufacturer;
	private int numberOfInterests;
	private int requestDigitalGreenCertificate;
	private int DigitalGreenCertificate;
	private LocalDateTime dateOfIssue;
}
