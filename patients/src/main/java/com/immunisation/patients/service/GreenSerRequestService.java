package com.immunisation.patients.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunisation.patients.jaxb.JaxB;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.model.request.RequestDigitalGreenCertificate;
import com.immunisation.patients.repository.GreenSerRequestRepository;

@Service
public class GreenSerRequestService {
	@Autowired
	private JaxB jaxb;
	
	@Autowired
	private GreenSerRequestRepository repository;
	
	
	
	public void saveRequestFromString(String request) throws Exception {
		RequestDigitalGreenCertificate requestObj = jaxb.unmarshall(RequestDigitalGreenCertificate.class, request);
		
		String id = UUID.randomUUID().toString();
		requestObj.setId(id);
		requestObj.setAbout("http://www.baklavice.com/rdf/zahtev_za_sertifikat/" + id);
		requestObj.setCode(id);
		String updated = jaxb.marshall(RequestDigitalGreenCertificate.class, requestObj);
		
		repository.saveRequest(updated, id);
		
	}
}
