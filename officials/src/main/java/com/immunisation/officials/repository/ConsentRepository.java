package com.immunisation.officials.repository;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.model.consent.PartForPublicOfficial;
import com.immunisation.officials.xmldb.ExistManager;

@Repository
public class ConsentRepository {
	
	private String collectionUri = "/db/eUprava/FinishedConsets";
	private String patientCollectionUri = "/db/eUprava/PacientConsents";

    @Autowired
    private ExistManager existManager;
    
    
    public ConsentForVaccination[] getAllUnfinishedConsents() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, JAXBException {
    	String[] xmldocs = existManager.loadXmlDocsToCollection(patientCollectionUri);
    	ConsentForVaccination[] consents = new ConsentForVaccination[xmldocs.length];
    	
    	for(int i = 0; i<xmldocs.length; i++) {
    		consents[i] = this.converStringToConsent(xmldocs[i]);
    	}
    	return consents;
    }
   
    public void saveRequest(String text, String docUri) throws Exception {
		existManager.storeFromText(collectionUri, docUri + ".xml", text);
	}
	
    
    
    private ConsentForVaccination converStringToConsent(String xml) throws JAXBException {
    	StringReader reader = new StringReader(xml);
    	JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.consent");
		Unmarshaller unmarshaller = context.createUnmarshaller();	
		
		return (ConsentForVaccination) unmarshaller.unmarshal(reader);
    }

}
