package com.immunisation.patients.repository;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.immunisation.patients.model.authority.Authority;
import com.immunisation.patients.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;

@Repository
public class AuthorityRepository {
	
	private String collectionUri = "/db/eUprava/authorities";

	@Autowired
	private ExistManager existManager;
	
	
	public Authority findByName(String name) throws Exception {
		Node auth = existManager.loadAsDOM(collectionUri, name+".xml");
		
		if(auth == null) {
			return null;
		}
		
		JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.authority");
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Authority authInstance = (Authority) unmarshaller.unmarshal(auth);
		return authInstance;
	}

	public void save(String name, long id) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.authority");

        Marshaller marshaller = context.createMarshaller();

        Authority auth = new Authority();
        auth.setName(name);
        auth.setId(id);
        StringWriter sw = new StringWriter();
        marshaller.marshal(auth, sw);
        existManager.storeFromText(collectionUri, name + ".xml", sw.toString());
    }
	
}
