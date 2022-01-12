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

import com.immunisation.officials.model.Patient;
import com.immunisation.officials.model.interesovanje.RequestVaccination;
import com.immunisation.officials.model.interesovanje.VaccinationData;
import com.immunisation.officials.model.izvestaj.DosesForReport;
import com.immunisation.officials.model.izvestaj.Manufacturer;
import com.immunisation.officials.model.izvestaj.Period;
import com.immunisation.officials.model.izvestaj.Report;
import com.immunisation.officials.model.izvestaj.VaccineDosesForReport;
import com.immunisation.officials.model.saglasnost.ConsentForVaccination;
import com.immunisation.officials.model.saglasnost.PartForPatients;
import com.immunisation.officials.model.saglasnost.PartForPublicOfficial;
import com.immunisation.officials.model.tipovi.Contact;
import com.immunisation.officials.model.tipovi.GeneralUser;
import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;



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
	
	public static void print(RequestVaccination request) {
		System.out.println("INTERESOVANJE");
		System.out.println("Sifra_interesovanja --> " + request.getCode());
		System.out.print("Podaci_o_licu --> ");
		printGeneralUser(request.getPatient());
		System.out.print("Kontakt --> ");
		print(request.getContact());
		System.out.print("Podaci_o_vakcinaciji --> ");
		print(request.getVaccinationData());
	
		System.out.println("Datum_interesovanja --> " + request.getDate());
	}
	
	public static void print(Contact contact) {
		System.out.println("KONTAKT");
		System.out.println("Broj_mobilnog --> " + contact.getCellphone());
		System.out.println("Broj_fixnog --> " + contact.getLandline());
		System.out.println("Email --> " + contact.getEmail());
	}
	
	public static void print(VaccinationData data) {
		System.out.println("PODACI O VAKCINACIJI");
		System.out.println("Opstina_ustanove --> " + data.getTownshipOfInstitution());
		System.out.println("Tip_vakcine --> " + data.getVaccineType());
		System.out.println("Davalac_krvi --> " + data.isBloodDonor());
	}
	
	public static void print(ConsentForVaccination data) {
		System.out.println("SAGLASNOST");
		System.out.print("Deo_za_pacijenta --> ");
		print(data.getPartForPatients());
		System.out.print("Deo_za_radnika --> ");
		print(data.getPartForPublicOfficial());
	}
	
	public static void print(PartForPatients part) {
		System.out.println("DEO ZA PACIJENTA");
		System.out.print("Licni_podaci --> ");
		print(part.getPatient());
		System.out.println("Pacijent_je_saglasan --> " + part.isPatientAgrees());
		System.out.println("Tip_vakcine --> " + part.getVaccineType());
		System.out.println("Datum_saglasnosti --> " + part.getDate());
	}
	
	public static void print(Patient data) {
		System.out.println("PACIJENT");
		System.out.println("Ime_roditelja --> " + data.getNameOfParent());
		System.out.println("Mesto_rodjenja --> " + data.getBirthPlace());
		System.out.println("Adresa --> " + data.getAddress());
		System.out.print("Kontakt --> ");
		print(data.getContact());
		System.out.println("Radni_status --> " + data.getEmploymentStatus());
		System.out.println("Zanimanje_zaposlenog --> " + data.getProfession());
		System.out.println("Socijalna_zastita --> " + data.isSocialCare());
		System.out.println("Sediste_socijalne_zastite --> " + data.getHeadquarterOfSocialCare());
	}
	
	public static void print(PartForPublicOfficial part) {
		System.out.println("DEO ZA RADNIKA");
		System.out.println("Zdravstvena_ustanova --> " + part.getHealthFacility());
		System.out.println("Vakcinacijski_punkt --> " + part.getVaccinationPoint());
		System.out.println("Podaci_o_lekaru --> " + part.getDoctorData());
		System.out.println("Naziv_vakcine --> " + part.getNamesOfVaccine());
		System.out.println("Datum_davanja_vakcine --> " + part.getDatesOfVaccination());
		System.out.println("Nacin_davanja_vakcine --> " + part.getWaysOfGivingTheVaccine());
		System.out.println("Ekstremitet --> " + part.getLimbs());
		System.out.println("Serija_vakcine --> " + part.getVaccineSeries());
		System.out.println("Proizvodjac --> " + part.getManufacturers());
		System.out.println("Nezeljena_reakcija --> " + part.getSideEffects());
		System.out.println("Privremene_kontraindikacije --> " + part.getTemporaryContractions());
		System.out.println("Trajne_kontraindikacije --> " + part.getPermanentContractions());
	}
	
	public static void print(Period period) {
		System.out.println("Datum_od --> " + period.getDateFrom());
		System.out.println("Datum_do --> " + period.getDateTo());
	}
	
	public static void print(VaccineDosesForReport vd) {
		System.out.println("Ukupno_datih_doza --> " + vd.getTotalNumberOfGivenDoses());
		for (DosesForReport d : vd.getDoses()) {
			System.out.println("Redni broj --> " + d.getOrdinalNumber());
			System.out.println("Broj datih doza --> " + d.getNumberOfGivenDoses());
		}
	}
	
	public static void print(Report report) {
		System.out.println("IZVESTAJ O IMUNIZACIJI");
		System.out.println("Sifra_izvestaja --> " + report.getCode());
		print(report.getPeriod());
		System.out.println("Broj_interesovanja --> " + report.getNumberOfInterests());
		System.out.println("Zahtevi_za_sertifikata --> " + report.getRequestDigitalGreenCertificate());
		System.out.println("Izdati_sertifikati --> " + report.getDigitalGreenCertificate());
		print(report.getVaccineDosesForReport());
		System.out.println("RASPODELA PROIZVODJACA");
		for (Manufacturer m : report.getDistributionOfManufacturers()) {
			System.out.println("Proizvodjac -- > " + m.getManufecturerName());
			System.out.println("Broj_doza --> " + m.getNumberOfDoses());
		}
		System.out.println("Datum_izdavanja --> " + report.getDateOfIssue());
	}
	
	/*public static void printVaccineConfirmation(VaccineConfirmation vc) {
		System.out.println("POTVRDA O VAKCINACIJI");
		System.out.println("Sifra_izvestaja --> " + report.getCode());
		printPeriod(report.getPeriod());
		System.out.println("Broj_interesovanja --> " + report.getNumberOfInterests());
		System.out.println("Zahtevi_za_sertifikata --> " + report.getRequestDigitalGreenCertificate());
		System.out.print("Izdati_sertifikati --> " + report.getDigitalGreenCertificate());
		printVaccineDoses(report.getVaccineDosesForReport());
		printDistribution(report.getDistributionOfManufacturer());
		System.out.println("Datum_izdavanja --> " + report.getDateOfIssue());
	}*/
	
	public static void parseRequestDigitalGreenCertificate() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.zahtev_za_sertifikat");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Zahtev_za_sertifikat.xsd"));      
		unmarshaller.setSchema(schema);
		
		//RequestDigitalGreenCertificate request = (RequestDigitalGreenCertificate)unmarshaller.unmarshal(new File("./data/Zahtev_za_sertifikat.xml"));
		RequestDigitalGreenCertificate r = unmarshaller.unmarshal(new StreamSource(new File("./data/Zahtev_za_sertifikat.xml")), RequestDigitalGreenCertificate.class).getValue();
		print(r);
		
		/*// Izvestaj o imunizaciji (Report)
		
		
		// Potvrda o vakcinaciji (VaccineConfirmation)
		context = JAXBContext.newInstance("com.immunisation.officials.model.potvrda");
		
		unmarshaller = context.createUnmarshaller();		
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schema = schemaFactory.newSchema(new File("./data/Potvrda_o_vakcinaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		VaccineConfirmation vc = unmarshaller.unmarshal(new StreamSource(new File("./data/Potvrda_o_vakcinaciji.xml")), VaccineConfirmation.class).getValue();
		printVaccineConfirmation(vc);*/
	}
	
	public static void parseRequestVaccination() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.interesovanje");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Interesovanje.xsd"));      
		unmarshaller.setSchema(schema);
		
		RequestVaccination r = unmarshaller.unmarshal(new StreamSource(new File("./data/Interesovanje.xml")), RequestVaccination.class).getValue();
		print(r);
	}
	
	public static void parseConsentForVaccination() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.saglasnost");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Saglasnost.xsd"));      
		unmarshaller.setSchema(schema);
		
		ConsentForVaccination r = unmarshaller.unmarshal(new StreamSource(new File("./data/Saglasnost.xml")), ConsentForVaccination.class).getValue();
		print(r);
	}
	
	public static void parseReport() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.izvestaj");
	
		Unmarshaller unmarshaller = context.createUnmarshaller();		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("./data/Izvestaj_o_imunizaciji.xsd"));      
		unmarshaller.setSchema(schema);
		
		Report report = unmarshaller.unmarshal(new StreamSource(new File("./data/Izvestaj_o_imunizaciji.xml")), Report.class).getValue();
		print(report);
	}
	
	public static void main(String[] args) throws JAXBException, SAXException {
		SpringApplication.run(OfficialsApplication.class, args);

		//Zahtev za zeleni sertifikat xml i xsd parsiranje
		//parseRequestDigitalGreenCertificate();
		
		//parseRequestVaccination();
		//parseConsentForVaccination();
		
		parseReport();
	}
}
