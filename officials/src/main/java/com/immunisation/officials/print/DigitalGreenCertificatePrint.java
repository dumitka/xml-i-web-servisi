package com.immunisation.officials.print;

import com.immunisation.officials.model.green_certificate.CertificateInfo;
import com.immunisation.officials.model.green_certificate.DigitalGreenCertificate;
import com.immunisation.officials.model.green_certificate.Vaccination;
import com.immunisation.officials.model.green_certificate.VaccinationInfo;

public class DigitalGreenCertificatePrint {
	public static void print(CertificateInfo info) {
		System.out.println("INFO SETRIFIKAT");
		System.out.println("Broj_sertifikata --> " + info.getCertificateNumber());
		System.out.println("Datum_izdavanja --> " + info.getDateOfIssue());
	}
	
	public static void print(Vaccination vaccination) {
		System.out.println("VAKCINACIJA");
		System.out.println("Doza --> " + vaccination.getDose());
		System.out.println("Tip --> " + vaccination.getVaccineType());
		System.out.println("Proizvodjac --> " + vaccination.getManufacturer());
		System.out.println("Serija --> " + vaccination.getSeries());
		System.out.println("Zdravsvena_ustanova --> " + vaccination.getHealthFacility());
	}
	
	public static void print(VaccinationInfo info) {
		System.out.println("INFO VAKCINACIJA");
		for (Vaccination v : info.getVaccinations()) {
			print(v);
		}
	}
	
	public static void print(DigitalGreenCertificate dgc) {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("DIGITALNI ZELIENI SERTIFIKAT");
		System.out.println("---------------------------------------------");
		print(dgc.getCertificateInfo());
		GeneralUserPrint.print(dgc.getUser());
		print(dgc.getVaccinationInfo());
		System.out.println("---------------------------------------------");
	}
}
