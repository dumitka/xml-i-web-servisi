package com.immunisation.patients.xmldb;

import javax.xml.transform.OutputKeys;

import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

@Service
public class ExistManager {
	
	@Autowired
	private AuthenticationUtilities utilities;
	
	
	
	public Collection getOrCreateCollection(String collUri, int pathOffset) throws Exception {
		
		Collection coll = DatabaseManager.getCollection(utilities.getUri() + collUri, utilities.getUser(), utilities.getPassword());
		
		if(coll == null) {
			if(collUri.startsWith("/")) {
				collUri = collUri.substring(1);
			}
			
			String pathSegments[] = collUri.split("/");
			
			if( pathSegments.length > 0) {
				StringBuilder path = new StringBuilder();
				for(int i =0; i <= pathOffset; i++) {
					path.append("/" + pathSegments[i]);
				}
//				Collection startCol = DatabaseManager.getCollection(utilities.getUri()+,)
				
				
				
				
			}
			
		} else {
			return coll;
		}
	}
	
	
	
	public void storeFromText(String collectionUri, String string, String text) {
		// TODO Auto-generated method stub
		
	}
	
	//IZ RETRIEVE

	public String[] loadXmlDocsToCollection(String collectionUri) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		
		connectToDb();
		
		Collection col = null;
		XMLResource res = null;
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(), utilities.getPassword());
			col.setProperty(OutputKeys.INDENT, "yes");
			String[] xmldocs = new String[col.getResourceCount()];
			
			//mozda ovdje problem
			for(int i = 0; i < col.getResourceCount(); i++) {
				String documentId = col.listResources()[i];
				XMLResource resource = (XMLResource) col.getResource(documentId); //getResource(documentId)
				xmldocs[i] = (String)resource.getContent();
			}
			
			//SVI DOKUMENTI, ne jedan
			return xmldocs;
		} finally {
			if(col != null) {
				col.close();
			}
		}
	}

	
	private void connectToDb() throws ClassNotFoundException, XMLDBException, InstantiationException, IllegalAccessException {
		// Inicijalizacija database driver-a
		Class<?> cl = Class.forName(utilities.getDriver());
		
		 // Enkapsulacija funkcionalnosti database driver-a
		Database database = (Database) cl.newInstance();
		database.setProperty("create-database", "true");
		
		 // Entry point za API koji omogućava dobavljanje reference kolekcije
        DatabaseManager.registerDatabase(database);
	}
	
	private void disconnectFromDb(Collection col, XMLResource res) throws XMLDBException {
		if(col != null) {
			col.close();
		}
		if(res != null) {
			((EXistResource)res).freeResources(); 
		}
	}
	
}
