package com.immunisation.patients.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.immunisation.patients.xmldb.ExistManager;

@Repository
public class ConsentRepository {

	private String collectionUri = "/db/eUprava/PacientConsents";
	
	@Autowired
	private ExistManager existManager;
	
	
	public void saveRequest(String text, String docUri) throws Exception {
		existManager.storeFromText(collectionUri, docUri + ".xml", text);
	}
	
	
	
	
}
