package com.immunisation.patients.repository;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immunisation.patients.model.request.RequestDigitalGreenCertificate;
import com.immunisation.patients.xmldb.ExistManager;

@Repository
public class GreenSerRequestRepository {

	private String collectionUri = "/db/eUprava/GreenSerRequests"; 
	
	@Autowired
	private ExistManager existManager;
	
	public void saveRequest(String text, String docUri) throws Exception {
		existManager.storeFromText(collectionUri, docUri + ".xml", text);
	}
	
	
	public void save(RequestDigitalGreenCertificate request) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request, sw);
        existManager.storeFromText(collectionUri, request.getCode() + ".xml", sw.toString());
    }
	
	
}
