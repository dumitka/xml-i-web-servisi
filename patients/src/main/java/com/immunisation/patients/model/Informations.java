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
public class Informations {
	private String name;
	private String type;
	private String manufacturer;
	private LocalDateTime testDate;
	
}
