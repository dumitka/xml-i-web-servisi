package com.immunisation.officials.xmldb;

import javax.xml.transform.OutputKeys;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

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
            	System.out.println("[INFO] Showing the document " + documentId);
            	System.out.println(res.getContent());
            }
            
            /*if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {
            	System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
                JAXBContext context = JAXBContext.newInstance("rs.ac.uns.ftn.examples.xmldb.bookstore");
    			
    			Unmarshaller unmarshaller = context.createUnmarshaller();
    			
    			Bookstore bookstore = (Bookstore) unmarshaller.unmarshal(res.getContentAsDOM());
    			
    			System.out.println("[INFO] Showing the document as JAXB instance: ");
    			System.out.println(bookstore);
            }*/
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