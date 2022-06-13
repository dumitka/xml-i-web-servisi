package com.immunisation.officials.service;

import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import com.immunisation.officials.dto.ConsentCollection;
import com.immunisation.officials.jaxb.JaxB;
import com.immunisation.officials.model.confirmation.VaccineConfirmation;
import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.repository.ConsentRepository;


@Service
public class ConsentService {
	@Autowired
	private JaxB jaxb;
	
	@Autowired
	ConsentRepository repository;
	
	public ConsentCollection getAllUnfinishedConsents() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, JAXBException {
		ConsentForVaccination[] consents = repository.getAllUnfinishedConsents();
		return new ConsentCollection(consents);
	}
	
	public void saveConsentFromString(String consent) throws Exception {
		ConsentForVaccination consentObj = jaxb.unmarshall(ConsentForVaccination.class, consent);
		
		String id = UUID.randomUUID().toString();
		consentObj.setId(id);
		consentObj.setAbout("http://www.baklavice.com/rdf/zahtev_za_saglasnost/" + id);
		consentObj.setCode(id);
		String updated = jaxb.marshall(ConsentForVaccination.class, consentObj);
		
		repository.saveRequest(updated, id);
		
	}
	
	
	public void saveConfirmFromString(String confirm) throws Exception {
		VaccineConfirmation consentObj = jaxb.unmarshall(VaccineConfirmation.class, confirm);
		
		String id = UUID.randomUUID().toString();
		consentObj.setId(id);
		consentObj.setAbout("http://www.baklavice.com/rdf/potvrda_vakcinacije/" + id);
		consentObj.setCode(id);
		String updated = jaxb.marshall(VaccineConfirmation.class, consentObj);
		
		repository.saveConfirm(updated, id);
		
	}
}
