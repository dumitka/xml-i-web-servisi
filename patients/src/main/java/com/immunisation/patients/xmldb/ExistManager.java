package com.immunisation.patients.xmldb;

import java.io.File;

import javax.xml.transform.OutputKeys;

import org.exist.xmldb.EXistResource;
import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;

@Service
public class ExistManager {
	
	private final static String TARGET_NAMESPACE = "http://nebitno.com"; //TODO mozda pravi problem?
	public static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
			+ "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
			+ "</xu:modifications>";
	public static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
			+ "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
			+ "</xu:modifications>";
	
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
				
				Collection startCol = DatabaseManager.getCollection(utilities.getUri() + path, utilities.getUser(), utilities.getPassword());
				
				if(startCol == null) {
					String parentPath = path.substring(0, path.lastIndexOf("/"));
					Collection parentCol = DatabaseManager.getCollection(utilities.getUri() + parentPath, utilities.getUser(), utilities.getPassword());
					
					CollectionManagementService service = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");
					
					coll = service.createCollection(pathSegments[pathOffset]);
					coll.close();
					parentCol.close();
				} else {
					startCol.close();
				}
			}
			return getOrCreateCollection(collUri, ++pathOffset);
			
		} else {
			return coll;
		}
	}
	
	//PREDLOG
	// db/interesovanja/interesovanje1
	// collectionId = interesovanja
	// documentId = interesovanje1
	
	public void store(String collectionId, String documentId, String filePath) throws Exception {
		connectToDb();
		Collection col = null;
		XMLResource res = null;
		try {
			col = getOrCreateCollection(collectionId, 0);
			res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
			File f = new File(filePath);

			if (!f.canRead()) {
				return;
			}
			res.setContent(f);
			col.storeResource(res);
		} finally {
			disconnectFromDb(col, res);
		}
	}
	
	
	public void storeFromText(String collectionId, String documentId, String xmlString) throws Exception {
		connectToDb();
		Collection col = null;
		XMLResource res = null;
		try {
			col = getOrCreateCollection(collectionId, 0);
			res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
			res.setContent(xmlString);
			col.storeResource(res);
		} finally {
			disconnectFromDb(col, res);
		}
	}
	
	public String load(String collectionUri, String documentId) throws Exception {
		connectToDb();
		Collection col = null;
		XMLResource res = null;
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(),
					utilities.getPassword());
			col.setProperty(OutputKeys.INDENT, "yes");
			res = (XMLResource) col.getResource(documentId);
			System.out.println(res);
			return (String) res.getContent();
		} finally {
			if (col != null) {
				col.close();
			}
		}
	}

	public Node loadAsDOM(String collectionUri, String documentId) throws Exception  {
		connectToDb();
		Collection col = null;
		XMLResource res = null;
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(),
					utilities.getPassword());
			col.setProperty(OutputKeys.INDENT, "yes");
			res = (XMLResource) col.getResource(documentId);
			return res.getContentAsDOM();
		} finally {
			if (col != null) {
				col.close();
			}
		}
	}
	
	
	public String[] retrieve(String collectionUri, String xpathExp, String prefix, String namespace) throws Exception {
		connectToDb();
		Collection col = null;
		ResourceSet result = null;
		String[] xmls = {};
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(),
					utilities.getPassword());
			XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
			xpathService.setProperty("indent", "yes");
			xpathService.setNamespace(prefix, namespace);
			result = xpathService.query(xpathExp);
			int len = (int) result.getSize();
			xmls = new String[len];
			for (int i = 0; i < len; i++){
				XMLResource xmlResource = (XMLResource) result.getResource(i);
				xmls[i] = (String) xmlResource.getContent();
			}
		} finally {
			if (col != null) {
				col.close();
			}
		}
		return xmls;
	}
	
	public void update(int template, String collectionUri, String document, String contextXPath, String patch)
			throws Exception {
		connectToDb();
		Collection col = null;
		String chosenTemplate = null;
		switch (template) {
		case 0: {
			chosenTemplate = UPDATE;
			break;
		}
		case 1: {
			chosenTemplate = APPEND;
			break;
		}
		default: {
			return;
		}
		}
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(),
					utilities.getPassword());
			XUpdateQueryService service = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
			service.setProperty("indent", "yes");
			service.updateResource(document, String.format(chosenTemplate, contextXPath, patch));
		} finally {
			if (col != null) {
				col.close();
			}
		}
	}

	
	public String[] loadXmlDocsToCollection(String collectionUri) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		
		connectToDb();
		
		Collection col = null;
		XMLResource res = null;
		try {
			col = DatabaseManager.getCollection(utilities.getUri() + collectionUri, utilities.getUser(), utilities.getPassword());
			col.setProperty(OutputKeys.INDENT, "yes");
			String[] xmldocs = new String[col.getResourceCount()];
			
			int i = 0;
			for (String documentId : col.listResources()) {
				XMLResource xmlResource = (XMLResource) col.getResource(documentId);
				xmldocs[i] = (String) xmlResource.getContent();
				i++;
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
