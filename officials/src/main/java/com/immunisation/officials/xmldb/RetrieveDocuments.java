package com.immunisation.officials.xmldb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.print.ConsentForVaccinationPrint;
import com.immunisation.officials.xmldb.AuthenticationUtilities.ConnectionProperties;

//Klasa koja služi za dobavljanje XML i XSD dokumenata iz exist bazu

public class RetrieveDocuments {
	public static void main(String[] args) throws Exception {
		RetrieveDocuments.run(AuthenticationUtilities.loadProperties(), args);
	}
    
    public static void run(ConnectionProperties conn, String args[]) throws Exception {
    	// initialize collection and document identifiers
        String collectionId = null;
		String documentId = null; 
        
		// Primer za dobavljanje saglasnosti
       	collectionId = "/db/immunisation/xml";
       	documentId = "Saglasnost.xml";

       	// Inicijalizacija database driver-a
        Class<?> cl = Class.forName(conn.driver);
        
        // Enkapsulacija funkcionalnosti database driver-a
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        
        // Entry point za API koji omogućava dobavljanje reference kolekcije
        DatabaseManager.registerDatabase(database);
        
        Collection col = null;
        XMLResource res = null;
        
        try {    
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");
            
            res = (XMLResource)col.getResource(documentId);
            
            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {
            	System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
    			JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.consent");
    			
    			Unmarshaller unmarshaller = context.createUnmarshaller();	
    			
    			ConsentForVaccination cfv = (ConsentForVaccination) unmarshaller.unmarshal(res.getContentAsDOM());
    			ConsentForVaccinationPrint.print(cfv);
            }
        } finally {
        	// Oslobađanje zauzetih resursa
            
            if(res != null) {
                try { 
                	((EXistResource)res).freeResources(); 
                } catch (XMLDBException xe) {
                	xe.printStackTrace();
                }
            }
            
            if(col != null) {
                try { 
                	col.close(); 
                } catch (XMLDBException xe) {
                	xe.printStackTrace();
                }
            }
        }
    }
}