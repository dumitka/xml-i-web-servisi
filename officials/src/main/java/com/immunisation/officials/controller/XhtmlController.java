package com.immunisation.officials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunisation.officials.xhtml.ConfirmationTransformer;
import com.immunisation.officials.xhtml.GreenCertificateTransformer;
import com.immunisation.officials.xhtml.InterestTransformer;
import com.immunisation.officials.xhtml.ReportTransformer;
import com.immunisation.officials.xhtml.RequestTransformer;

@RestController
@RequestMapping(value = "api/xhtml")
public class XhtmlController {

	@GetMapping(value="/")
	public ResponseEntity<Boolean> generate() {
		ConfirmationTransformer.generateXHTML("Potvrda_o_vakcinaciji.xml");
		GreenCertificateTransformer.generateXHTML("Digitalni_sertifikat1.xml");
		InterestTransformer.generateXHTML("Interesovanje.xml");
		ReportTransformer.generateXHTML("Izvestaj_o_imunizaciji.xml");
		RequestTransformer.generateXHTML("Zahtev_za_sertifikat.xml");
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
