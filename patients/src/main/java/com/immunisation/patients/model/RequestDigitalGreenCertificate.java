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
public class RequestDigitalGreenCertificate {
	private String statement;
	private Patient patient;
	private String reasonForRequest;
	private String place; //mjesto podnosenja zahtjeva
	private LocalDateTime date; //datum podnosenja zahtjeva
}
