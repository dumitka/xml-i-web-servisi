package com.immunisation.officials;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import com.immunisation.officials.model.Contact;
import com.immunisation.officials.model.GeneralUser;
import com.immunisation.officials.model.RequestVaccination;
import com.immunisation.officials.model.VaccinationData;
import com.immunisation.officials.model.Vaccine;

@SpringBootApplication
public class OfficialsApplication {
	
	public static void printGeneralUser(GeneralUser u) {
		System.out.println(u.getCitizenship());
		System.out.println(u.getGender());
		System.out.println(u.getName());
		System.out.println(u.getLastName());
		System.out.println(u.getResidence());
		System.out.println(u.getUPIN());
	}
	
	public static void printContact(Contact c) {
		System.out.println(c.getCellphone());
		System.out.println(c.getLandline());
		System.out.println(c.getEmail());
	}
	
	public static void printVaccinationData(VaccinationData v) {
		System.out.println(v.getTownshipOfInstitution());
		System.out.println(v.getVaccine());
		System.out.println(v.isBloodDonor());
	}
	
	public static void printVakcinu(Vaccine v) {
		System.out.println(v.getName());
	}
	
	public static void printR(RequestVaccination r) {
		printGeneralUser(r.getPatient());
		System.out.println("------------------------------------------------");
		printContact(r.getContact());
		System.out.println("------------------------------------------------");
		printVaccinationData(r.getVaccinationData());
		System.out.println("------------------------------------------------");
	}

	public static void main(String[] args) throws JAXBException, SAXException {
		SpringApplication.run(OfficialsApplication.class, args);

		// DefiniÅ¡e se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.parsers.requestVaccinationParser");

		// Unmarshaller je objekat zaduÅ¾en za konverziju iz XML-a u objektni model
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		// XML schema validacija
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Interesovanje.xsd"));
        
		// PodeÅ¡avanje unmarshaller-a za XML schema validaciju
		unmarshaller.setSchema(schema);
        
        // Test: proÅ¡iriti XML fajl nepostojeÄ‡im elementom (npr. <test></test>)
		RequestVaccination r = (RequestVaccination) unmarshaller.unmarshal(new File("./data/Interesovanje.xml"));

		printR(r);
        
	}

}
