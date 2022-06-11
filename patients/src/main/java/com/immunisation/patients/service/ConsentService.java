package com.immunisation.patients.service;

import java.util.UUID;
import com.immunisation.patients.jaxb.JaxB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunisation.patients.model.consent.ConsentForVaccination;
import com.immunisation.patients.repository.ConsentRepository;

@Service
public class ConsentService {
	@Autowired
	private JaxB jaxb;
	
	@Autowired
	private ConsentRepository repository;
	
	public void saveConsentFromString(String consent) throws Exception {
		ConsentForVaccination consentObj = jaxb.unmarshall(ConsentForVaccination.class, consent);
		
		String id = UUID.randomUUID().toString();
		consentObj.setId(id);
		consentObj.setAbout("http://www.baklavice.com/rdf/zahtev_za_sertifikat/" + id);
		consentObj.setCode(id);
		String updated = jaxb.marshall(ConsentForVaccination.class, consentObj);
		
		repository.saveRequest(updated, id);
		
	}
}
