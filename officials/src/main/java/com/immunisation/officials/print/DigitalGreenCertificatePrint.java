package com.immunisation.officials.print;

import com.immunisation.officials.model.digitalni_sertifikat.CertificateInfo;
import com.immunisation.officials.model.digitalni_sertifikat.DigitalGreenCertificate;
import com.immunisation.officials.model.digitalni_sertifikat.Vaccination;
import com.immunisation.officials.model.digitalni_sertifikat.VaccinationInfo;
import com.immunisation.officials.model.tipovi.GeneralUser;

public class DigitalGreenCertificatePrint {
	public static void printCertificateInfo(CertificateInfo info) {
		System.out.println("INFO CETRIFIKAT");
		System.out.println("Broj_sertifikata --> " + info.getCertificateNumber());
		System.out.println("Datum_izdavanja --> " + info.getDateOfIssue());
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
	
	public static void print(DigitalGreenCertificate certificate) {
		System.out.println("DIGITALNI ZELIENI SERTIFIKAT");
		
		System.out.println("Info certifikat:");
		printCertificateInfo(certificate.getCertificateInfo());
		System.out.println("");
		
		System.out.println("Korisnik Opste:");
		printGeneralUser(certificate.getUser());
		System.out.println("");
		
		System.out.println("Vakcinacija info:");
		printVaccinationInfo(certificate.getVaccinationInfo());
		System.out.println("");
	}
}
