package com.immunisation.officials.print;

import com.immunisation.officials.model.digitalni_sertifikat.CertificateInfo;
import com.immunisation.officials.model.digitalni_sertifikat.DigitalGreenCertificate;
import com.immunisation.officials.model.digitalni_sertifikat.Header;
import com.immunisation.officials.model.digitalni_sertifikat.Informations;
import com.immunisation.officials.model.digitalni_sertifikat.Publisher;
import com.immunisation.officials.model.digitalni_sertifikat.Results;
import com.immunisation.officials.model.digitalni_sertifikat.Test;
import com.immunisation.officials.model.digitalni_sertifikat.TestInfo;
import com.immunisation.officials.model.digitalni_sertifikat.Vaccination;
import com.immunisation.officials.model.digitalni_sertifikat.VaccinationInfo;
import com.immunisation.officials.model.tipovi.Address;
import com.immunisation.officials.model.tipovi.GeneralUser;

public class DigitalGreenCertificatePrint {
	
	public static void printHeder(Header header) {
		System.out.println("ZAGLAVLJE");
		System.out.println("Grb --> " + header.getCoatOfArms());
		System.out.println("Naslov --> " + header.getTitle());
		System.out.println("QR kod --> " + header.getQRCode());
	}
	
	
	public static void printAddress(Address address) {
		System.out.println("ADRESA");
		System.out.println("Opstina --> " + address.getTownship());
		System.out.println("Mesto --> " + address.getPlace());
		System.out.println("Ulica --> " + address.getStreet());
		System.out.println("Broj --> " + address.getNumber());
	}
	
	public static void printPublisher(Publisher publisher) {
		System.out.println("IZDAVAC");
		System.out.println("Grb --> " + publisher.getCoatOfArms());
		System.out.println("Adresa_institucije:");
		printAddress(publisher.getInstitutionAdress());
	}
	
	public static void printCertificateInfo(CertificateInfo info) {
		System.out.println("INFO CETRIFIKAT");
		System.out.println("Broj_sertifikata --> " + info.getCertificateNumber());
		System.out.println("Datum_izdavanja --> " + info.getDateOfIssue());
		System.out.println("Izdavac:");
		printPublisher(info.getPublisher());
	}
	
	
	public static void printGeneralUser(GeneralUser user) {
		System.out.println("KORISNIK OPSTE");
		System.out.println("Drzavljanstvo --> " + user.getCitizenship());
		System.out.println("Boraviste --> " + user.getResidence());
		System.out.println("Ime --> " + user.getName());
		System.out.println("Prezime --> " + user.getLastName());
		System.out.println("Pol --> " + user.getGender());
		System.out.println("Datum_rodjenja --> " + user.getBirthdate());
		System.out.println("Licni dokument --> " + user.getDocument());
	}
	
	
	public static void printVaccination(Vaccination vaccination) {
		System.out.println("VAKCINACIJA");
		System.out.println("Doza --> " + vaccination.getDose());
		System.out.println("Tip --> " + vaccination.getVaccineType());
		System.out.println("Proizvodjac --> " + vaccination.getManufacturer());
		System.out.println("Serija --> " + vaccination.getSeries());
		System.out.println("Zdravsvena_ustanova --> " + vaccination.getHealthFacility());
	}
	
	
	public static void printVaccinationInfo(VaccinationInfo info) {
		for(int i = 0; i<info.getVaccinations().size(); i++) {
			printVaccination(info.getVaccinations().get(i));
			System.out.println("-------------------------------------------------------------");
		}
	}
	
	
	public static void printInformations(Informations info) {
		System.out.println("INFORMACIJE");
		System.out.println("Naziv --> " + info.getName());
		System.out.println("Vrsta --> " + info.getType());
		System.out.println("Proizvodjac --> " + info.getManufacturer());
		System.out.println("Datum_testiranja --> " + info.getTestDate());
	}
	
	public static void printResult(Results results) {
		System.out.println("REZULTATI");
		System.out.println("Opis --> " + results.getDescription());
		System.out.println("Laboratorija:");
		printAddress(results.getLab());
		System.out.println("Datum_rezultata --> " + results.getResultsDate());
	}
	
	
	
	public static void printTest(Test test) {
		System.out.println("TEST");
		System.out.println("Opis --> " + test.getNumber());
		System.out.println("Informacije:");
		printInformations(test.getInformations());
		System.out.println("Rezultati:");
		printResult(test.getResults());
	}
	
	
	public static void printTestInfo(TestInfo info) {
		for(int i = 0; i<info.getTests().size(); i++) {
			printTest(info.getTests().get(i));
			System.out.println("-------------------------------------------------------------");
		}
	}
	
	public static void print(DigitalGreenCertificate certificate) {
		System.out.println("DIGITALNI ZELIENI SERTIFIKAT");
		System.out.println("Zaglavlje:");
		printHeder(certificate.getHeader());
		System.out.println("");
		
		System.out.println("Info certifikat:");
		printCertificateInfo(certificate.getCertificateInfo());
		System.out.println("");
		
		System.out.println("Korisnik Opste:");
		printGeneralUser(certificate.getUser());
		System.out.println("");
		
		System.out.println("Vakcinacija info:");
		printVaccinationInfo(certificate.getVaccinationInfo());
		System.out.println("");
		
		System.out.println("Test info:");
		printTestInfo(certificate.getTest());
		System.out.println("");
		
		
	}
}
