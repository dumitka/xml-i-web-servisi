package com.immunisation.officials;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import com.immunisation.officials.model.confirmation.VaccineConfirmation;
import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.model.green_certificate.DigitalGreenCertificate;
import com.immunisation.officials.model.interest.Interest;
import com.immunisation.officials.model.report.Report;
import com.immunisation.officials.model.request.RequestDigitalGreenCertificate;
import com.immunisation.officials.model.types.GeneralUser;
import com.immunisation.officials.print.ConsentForVaccinationPrint;
import com.immunisation.officials.print.DigitalGreenCertificatePrint;
import com.immunisation.officials.print.InterestPrint;
import com.immunisation.officials.print.ReportPrint;
import com.immunisation.officials.print.RequestDigitalGreenCertificatePrint;
import com.immunisation.officials.print.VaccineConfirmationPrint;

@SpringBootApplication
public class OfficialsApplication {
	public static void printGeneralUser(GeneralUser user) {
		System.out.println("GENERAL USER");
		System.out.println("Drzavljanstvo --> " + user.getCitizenship());
		System.out.println("Boraviste --> " + user.getResidence());
		System.out.println("Ime --> " + user.getName());
		System.out.println("Prezime --> " + user.getLastName());
		System.out.println("Pol --> " + user.getGender());
		System.out.println("Datum_rodjenja --> " + user.getBirthdate());
		System.out.println("Licni dokument --> " + user.getDocument());
	}
	
	public static void print(RequestDigitalGreenCertificate request) {
		System.out.println("ZAHTEV ZA DIGITALNI ZELIENI SERTIFIKAT");
		System.out.println("Sifra_zahteva --> " + request.getCode());
		System.out.println("Ime_dokumenta --> " + request.getName());
		System.out.print("Podaci_o_podnosiocu --> ");
		printGeneralUser(request.getUser());
		System.out.println("Razlog_podnosenja_zahteva --> " + request.getReasonForRequest());
		System.out.println("Mesto_podnosenja_zahteva --> " + request.getPlace());
		System.out.println("Datum_podnosenja_zahteva --> " + request.getDate());
	}
	
	public static void parseVaccineConfirmation() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.confirmation");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Potvrda_o_vakcinaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		VaccineConfirmation vc = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Potvrda_o_vakcinaciji.xml")), VaccineConfirmation.class).getValue();
		VaccineConfirmationPrint.print(vc);
	}
	
	public static void parseConsentForVaccination() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.consent");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Saglasnost.xsd"));      
		unmarshaller.setSchema(schema);
		
		ConsentForVaccination cfv = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Saglasnost.xml")), ConsentForVaccination.class).getValue();
		ConsentForVaccinationPrint.print(cfv);
	}
	
	public static void parseDigitalGreenCertificate() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.green_certificate");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Digitalni_sertifikat.xsd"));      
		unmarshaller.setSchema(schema);
		
		DigitalGreenCertificate dgc = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Digitalni_sertifikat1.xml")), DigitalGreenCertificate.class).getValue();
		DigitalGreenCertificatePrint.print(dgc);
	}
	
	public static void parseInterest() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.interest");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Interesovanje.xsd"));      
		unmarshaller.setSchema(schema);
		
		Interest i = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Interesovanje.xml")), Interest.class).getValue();
		InterestPrint.print(i);
	}
	
	public static void parseReport() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.report");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Izvestaj_o_imunizaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		Report report = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Izvestaj_o_imunizaciji.xml")), Report.class).getValue();
		ReportPrint.print(report);
	}
	
	public static void parseRequestDigitalGreenCertificate() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.request");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/xsd/Zahtev_za_sertifikat.xsd"));      
		unmarshaller.setSchema(schema);
		
		RequestDigitalGreenCertificate rdgc = unmarshaller.unmarshal(new StreamSource(new File("./data/xml/Zahtev_za_sertifikat.xml")), RequestDigitalGreenCertificate.class).getValue();
		RequestDigitalGreenCertificatePrint.print(rdgc);
	}
	
	public static void main(String[] args) throws JAXBException, SAXException {
		SpringApplication.run(OfficialsApplication.class, args);

		// Parsiranje potvrde o vakcinaciji (VaccineConfirmation)
		parseVaccineConfirmation();
		
		// Parsiranje saglasnosti (Consent)
		parseConsentForVaccination();
		
		// Parsiranje digitalnog sertifikata (DigitalGreenCertificate)
		parseDigitalGreenCertificate();
		
		// Parsiranje interesovanja (Interest)
		parseInterest();
		
		// Parsiranje izveštaja o imunizaciji (Report)
		parseReport();
		
		// Parsiranje zahteva za sertifikat (RequestDigitalGreenCertificate)
		parseRequestDigitalGreenCertificate();
	}
}
