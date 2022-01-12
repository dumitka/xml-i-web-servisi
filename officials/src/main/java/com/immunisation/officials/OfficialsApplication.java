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

import com.immunisation.officials.model.izvestaj.DistributionOfManufacturer;
import com.immunisation.officials.model.izvestaj.Manufacturer;
import com.immunisation.officials.model.izvestaj.Period;
import com.immunisation.officials.model.izvestaj.Report;
import com.immunisation.officials.model.izvestaj.VaccineDosesForReport;
import com.immunisation.officials.model.potvrda.VaccineConfirmation;
import com.immunisation.officials.model.tipovi.GeneralUser;
import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;



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
	
	public static void printPeriod(Period period) {
		System.out.println("Datum_od --> " + period.getDateFrom());
		System.out.println("Datum_do --> " + period.getDateTo());
	}
	
	public static void printVaccineDoses(VaccineDosesForReport vd) {
		System.out.println("Ukupno_datih_doza --> " + vd.getTotalNumberOfGivenDoses());
		System.out.println("Doza --> " + vd.getDose());
	}
	
	public static void printDistribution(DistributionOfManufacturer dm) {
		System.out.println("RASPODELA PROIZVODJACA");
		for (Manufacturer m : dm.getManufacturers()) {
			//System.out.println("Proizvodjac -- > " + m.getVaccine());
			System.out.println("Broj_doza --> " + m.getNumberOfDoses());
		}
	}
	
	public static void printReport(Report report) {
		System.out.println("IZVESTAJ O IMUNIZACIJI");
		System.out.println("Sifra_izvestaja --> " + report.getCode());
		printPeriod(report.getPeriod());
		System.out.println("Broj_interesovanja --> " + report.getNumberOfInterests());
		System.out.println("Zahtevi_za_sertifikata --> " + report.getRequestDigitalGreenCertificate());
		System.out.print("Izdati_sertifikati --> " + report.getDigitalGreenCertificate());
		printVaccineDoses(report.getVaccineDosesForReport());
		printDistribution(report.getDistributionOfManufacturer());
		System.out.println("Datum_izdavanja --> " + report.getDateOfIssue());
	}
	
	public static void printVaccineConfirmation(VaccineConfirmation vc) {
		System.out.println("POTVRDA O VAKCINACIJI");
		System.out.println("Sifra_izvestaja --> " + report.getCode());
		printPeriod(report.getPeriod());
		System.out.println("Broj_interesovanja --> " + report.getNumberOfInterests());
		System.out.println("Zahtevi_za_sertifikata --> " + report.getRequestDigitalGreenCertificate());
		System.out.print("Izdati_sertifikati --> " + report.getDigitalGreenCertificate());
		printVaccineDoses(report.getVaccineDosesForReport());
		printDistribution(report.getDistributionOfManufacturer());
		System.out.println("Datum_izdavanja --> " + report.getDateOfIssue());
	}
	
	public static void parseRequestDigitalGreenCertificate() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.zahtev_za_sertifikat");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Zahtev_za_sertifikat.xsd"));      
		unmarshaller.setSchema(schema);
		
		//RequestDigitalGreenCertificate request = (RequestDigitalGreenCertificate)unmarshaller.unmarshal(new File("./data/Zahtev_za_sertifikat.xml"));
		RequestDigitalGreenCertificate r = unmarshaller.unmarshal(new StreamSource(new File("./data/Zahtev_za_sertifikat.xml")), RequestDigitalGreenCertificate.class).getValue();
		print(r);
		
		// Izvestaj o imunizaciji (Report)
		context = JAXBContext.newInstance("com.immunisation.officials.model.izvestaj");
		
		unmarshaller = context.createUnmarshaller();		
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schema = schemaFactory.newSchema(new File("./data/Izvestaj_o_imunizaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		Report report = unmarshaller.unmarshal(new StreamSource(new File("./data/Izvestaj_o_imunizaciji.xml")), Report.class).getValue();
		printReport(report);
		
		// Potvrda o vakcinaciji (VaccineConfirmation)
		context = JAXBContext.newInstance("com.immunisation.officials.model.potvrda");
		
		unmarshaller = context.createUnmarshaller();		
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schema = schemaFactory.newSchema(new File("./data/Potvrda_o_vakcinaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		VaccineConfirmation vc = unmarshaller.unmarshal(new StreamSource(new File("./data/Potvrda_o_vakcinaciji.xml")), VaccineConfirmation.class).getValue();
		printVaccineConfirmation(vc);
	}
	
	public static void main(String[] args) throws JAXBException, SAXException {
		SpringApplication.run(OfficialsApplication.class, args);

		//Zahtev za zeleni sertifikat xml i xsd parsiranje
		parseRequestDigitalGreenCertificate();
	}
}
