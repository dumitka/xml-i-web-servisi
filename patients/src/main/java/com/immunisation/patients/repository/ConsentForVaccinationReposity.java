package com.immunisation.patients.repository;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immunisation.patients.model.consent.ConsentForVaccination;
import com.immunisation.patients.xmldb.ExistManager;

@Repository
public class ConsentForVaccinationReposity {

	private String collectionUri = "/db/eUprava/saglasnosti";

	@Autowired
	private ExistManager existManager;

	public void save(ConsentForVaccination cfv) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.consent");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        marshaller.marshal(cfv, sw);

        existManager.storeFromText(collectionUri, cfv.getPartForPatients().getPatient().getDocument() + ".xml", sw.toString());
    }
}
