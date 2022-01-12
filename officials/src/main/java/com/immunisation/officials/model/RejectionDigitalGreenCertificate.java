package com.immunisation.officials.model;

import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;

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
public class RejectionDigitalGreenCertificate {
	private RequestDigitalGreenCertificate requestDigitalGreenCertificate;
	private String reason;
	
}
