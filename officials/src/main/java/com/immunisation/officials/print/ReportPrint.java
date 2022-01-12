package com.immunisation.officials.print;

import com.immunisation.officials.model.report.DosesForReport;
import com.immunisation.officials.model.report.Manufacturer;
import com.immunisation.officials.model.report.Period;
import com.immunisation.officials.model.report.Report;
import com.immunisation.officials.model.report.VaccineDosesForReport;

public class ReportPrint {
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
	
	public static void print(Report r) {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("IZVEŠTAJ O IMUNIZACIJI");
		System.out.println("---------------------------------------------");
		System.out.println("Sifra_izvestaja --> " + r.getCode());
		print(r.getPeriod());
		System.out.println("Broj_interesovanja --> " + r.getNumberOfInterests());
		System.out.println("Zahtevi_za_sertifikata --> " + r.getRequestDigitalGreenCertificate());
		System.out.println("Izdati_sertifikati --> " + r.getDigitalGreenCertificate());
		print(r.getVaccineDosesForReport());
		System.out.println("RASPODELA PROIZVODJACA");
		for (Manufacturer m : r.getDistributionOfManufacturers()) {
			System.out.println("Proizvodjac -- > " + m.getManufecturerName());
			System.out.println("Broj_doza --> " + m.getNumberOfDoses());
		}
		System.out.println("Datum_izdavanja --> " + r.getDateOfIssue());
		System.out.println("---------------------------------------------");
	}
}
