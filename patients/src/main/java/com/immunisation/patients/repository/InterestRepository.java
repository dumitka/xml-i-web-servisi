package com.immunisation.patients.repository;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

@Repository
public class InterestRepository {

	private String collectionUri = "/db/eUprava/interesovanja";  //menjati na interest

	@Autowired
	private ExistManager existManager;

	public void saveInterest(String text, String docUri) throws Exception {
		existManager.storeFromText(collectionUri, docUri + ".xml", text);
	}
	
	public Interest getInterestObj(String documentUri) throws Exception {
		String xml =  existManager.load(collectionUri, documentUri + ".xml");
		System.out.println(xml);
		return convertStringToInterest(xml);
	}
	
	public void save(Interest interest) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.interest");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        marshaller.marshal(interest, sw);

        existManager.storeFromText(collectionUri, interest.getCode() + ".xml", sw.toString());
    }
	

	public Interest[] getAll() throws SAXException, JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		// dobavi sve
		String[] xmldocs = existManager.loadXmlDocsToCollection(collectionUri);

		// inicijalizuj niz
		Interest[] interests = new Interest[xmldocs.length];

		for (int i = 0; i < xmldocs.length; i++) {
			interests[i] = convertStringToInterest(xmldocs[i]);
		}

		return interests;
	}

	private Interest convertStringToInterest(String xml) throws SAXException, JAXBException {
		StringReader reader = new StringReader(xml);
		//kod iz officials app

		JAXBContext context = JAXBContext.newInstance("com.immunisation.patients.model.interest");
		Unmarshaller unmarshaller = context.createUnmarshaller();	
		
		//dodavanje provere sa xsd -TODO mozemo kasnije, ali da vucemo iz baze podataka!
//		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Interesovanje.xsd"));      
//		unmarshaller.setSchema(schema);
		
		return (Interest) unmarshaller.unmarshal(reader);
	}

	//TODO GET JEDAN
	
}
