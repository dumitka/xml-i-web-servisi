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
public class DosesForReport {
	private int ordinalNumber;
	private int numberOfGivenDoses;
}