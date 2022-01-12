package com.immunisation.officials.xmldb;

import java.io.File;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import com.immunisation.officials.xmldb.AuthenticationUtilities.ConnectionProperties;

// Klasa koja služi za smeštanje XML i XSD dokumenata u exist bazu

public class StoreDocuments {
	private static ConnectionProperties conn;
	
    public static void main(String[] args) throws Exception {
    	// Konektovanje na bazu
		StoreDocuments.run(conn = AuthenticationUtilities.loadProperties());
	}
    
    public static void run(ConnectionProperties conn) throws Exception {
        // Inicijalizacija database driver-a
    	Class<?> cl = Class.forName(conn.driver);
        
        // Enkapsulacija funkcionalnosti database driver-a
    	Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        
        // Entry point za API koji omogućava dobavljanje reference kolekcije
        DatabaseManager.registerDatabase(database);

        // Dobavljanje naziva XML i XSD fajlova
		String[] xmlFiles = new File("data/xml").list();
		String[] xsdFiles = new File("data/xsd").list();
		
		// Skladištenje XML i XSD fajlova u exist bazu
        store("/db/immunisation/xml", xmlFiles, "data/xml/");
        store("/db/immunisation/xsd", xsdFiles, "data/xsd/");
    }
    
    // collectionId je putanja do kolekcije, documentId je id pod kojim ce se 
    // sačuvati dokument u kolekciji, a filePath je putanja do dokumenta
    private static void store(String collectionId, String[] documentIds, String filePath) throws XMLDBException {
        Collection col = null;
        XMLResource res = null;
        
        try { 
        	// Dobavljanje kolekcija iz baze ili kreiranje, ukoliko ne postoji
            col = getOrCreateCollection(collectionId);
            
            for (String documentId : documentIds) {
            	// Kreiranje XMLResource za fajl koji se upisuje u bazu
                res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
                
                File f = new File(filePath + documentId);
                
                if(!f.canRead()) {
                    System.out.println("[ERROR] Cannot read the file: " + filePath);
                    return;
                }
                
                // Postavljanje fajla kao sadržaja resursa
                res.setContent(f);
                
                // Smestanje resursa u kolekciju
                col.storeResource(res);
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
    
    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }
    
    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {
        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);
        
        // Kreiranje kolekcije ukoliko ne postoji u bazi
        if(col == null) {
         	if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }
            
        	String pathSegments[] = collectionUri.split("/");
            
        	if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();
            
                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }
                
                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);
                
                // Ne postoji dete kolekcije
                if (startCol == null) {
                	String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);
                    
                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);
                    
                    // Uvek je neophodno zatvoriti kolekciju na kraju
                    col.close();
                    parentCol.close();
                } else {
                    startCol.close();
                }
            }
            
        	return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
