package com.immunisation.officials.model;


import com.immunisation.officials.model.green_certificate.DigitalGreenCertificate;
import com.immunisation.officials.model.request.RequestDigitalGreenCertificate;

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
public class ApprovalDigitalGreenCertificate {
	private DigitalGreenCertificate digitalGreenCertificate;
	private RequestDigitalGreenCertificate requestDigitalGreenCertificate;
	private String message;
}
