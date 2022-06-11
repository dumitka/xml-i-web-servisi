package com.immunisation.officials.repository;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.xmldb.ExistManager;

@Repository
public class ConsentForVaccinationRepository {
	private String collectionUri = "/db/eUprava/saglasnosti";

    @Autowired
    private ExistManager existManager;
	
	public List<String> getJmbgs() throws Exception {
		String[] xmls = existManager.loadXmlDocsToCollection(collectionUri);
        List<String> jmbgs = new ArrayList<>();

        for (int i = 0; i < xmls.length; i++) {
        	jmbgs.add(cfvFromString(xmls[i]).getPartForPatients().getPatient().getDocument());
        }

        return jmbgs;
	}
	
	private ConsentForVaccination cfvFromString(String xml) throws JAXBException {
		StringReader stringReader = new StringReader(xml);

		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.consent");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		return (ConsentForVaccination) unmarshaller.unmarshal(stringReader);
	}
}
