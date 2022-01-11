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

import com.immunisation.officials.model.Contact;
import com.immunisation.officials.model.DistributionOfManufacturer;
import com.immunisation.officials.model.DosesForReport;
import com.immunisation.officials.model.GeneralUser;
import com.immunisation.officials.model.Manufacturer;
import com.immunisation.officials.model.Period;
import com.immunisation.officials.model.Report;
import com.immunisation.officials.model.RequestVaccination;
import com.immunisation.officials.model.VaccinationData;
import com.immunisation.officials.model.Vaccine;
import com.immunisation.officials.model.VaccineDosesForReport;

@SpringBootApplication
public class OfficialsApplication {
	
	public static void printGeneralUser(GeneralUser u) {
		System.out.println("Drzavljanstvo: " + u.getCitizenship());
		System.out.println("Pol: " + u.getGender());
		System.out.println("Ime: " + u.getName());
		System.out.println("Prezime: " + u.getLastName());
		System.out.println("Boraviste: " + u.getResidence());
		System.out.println("JMBG/Broj pasos: " + u.getDocument());
	}
	
	public static void printContact(Contact c) {
		System.out.println("Mobilni: " + c.getCellphone());
		System.out.println("Fiksni: " + c.getLandline());
		System.out.println("Email: " + c.getEmail());
	}
	
	public static void printVaccinationData(VaccinationData v) {
		System.out.println("Opstina: " + v.getTownshipOfInstitution());
		System.out.println("Vakcina: " + v.getVaccine());
		System.out.println("Davalac krvi: " + v.isBloodDonor());
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
		System.out.println("Datum interesovanja: " + r.getDate());
	}
	
	public static void printPeriod(Period p) {
		System.out.println("Od: " + p.getDateFrom());
		System.out.println("Do: " + p.getDateTo());
	}
	
	public static void printDose(DosesForReport d) {
		System.out.println("Redni broj: " + d.getOrdinalNumber());
		System.out.println("Broj datih doza: " + d.getNumberOfGivenDoses());
	}
	
	public static void printVD(VaccineDosesForReport vd) {
		System.out.println("Ukupno datih doza: " + vd.getTotalNumberOfGivenDoses());
		printDose(vd.getDose());
	}
	
	public static void printDM(DistributionOfManufacturer dm) {
		for (Manufacturer m : dm.getManufacturers()) {
			System.out.println("Manufacturer: " + m.getNumberOfDoses());
		}
	}
	
	public static void printReport(Report r) {
		printPeriod(r.getPeriod());
		System.out.println("------------------------------------------------");
		System.out.println("Broj interesovanja: " + r.getNumberOfInterests());
		System.out.println("------------------------------------------------");
		System.out.println("Zeleni sert: " + r.getDigitalGreenCertificate());
		System.out.println("------------------------------------------------");
		printVD(r.getVaccineDosesForReport());
		System.out.println("------------------------------------------------");
		printDM(r.getDistributionOfManufacturer());
		System.out.println("------------------------------------------------");
		System.out.println("Datum izdavanja: " + r.getDateOfIssue());
	}
	
	public static void parseRequestVaccination() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model");

		Unmarshaller unmarshaller = context.createUnmarshaller();
				
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Interesovanje.xsd"));
		        
		unmarshaller.setSchema(schema);
		        
		RequestVaccination r = unmarshaller.unmarshal(new StreamSource(new File("./data/Interesovanje.xml")), RequestVaccination.class).getValue();

		printR(r);
	}
	
	public static void parseReport() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model");

		Unmarshaller unmarshaller = context.createUnmarshaller();
				
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Izvestaj_o_imunizaciji.xsd"));
		        
		unmarshaller.setSchema(schema);
		        
		Report r = unmarshaller.unmarshal(new StreamSource(new File("./data/Izvestaj_o_imunizaciji.xml")), Report.class).getValue();

		printReport(r);
	}

	public static void main(String[] args) throws JAXBException, SAXException {
		SpringApplication.run(OfficialsApplication.class, args);

		parseRequestVaccination();
		parseReport();
	}
}
