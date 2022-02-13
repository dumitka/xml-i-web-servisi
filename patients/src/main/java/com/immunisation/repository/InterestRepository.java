package com.immunisation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immunisation.xmldb.ExistManager;

@Repository
public class InterestRepository {
	
	private String collectionUri = "/db/imunizacija/interesovanja";
	
	@Autowired
	private ExistManager existManager;
	
	public void saveInterest(String text, String docUri) throws Exception {
		existManager.storeFromText(collectionUri, docUri + ".xml", text);
	}
	
	

}
