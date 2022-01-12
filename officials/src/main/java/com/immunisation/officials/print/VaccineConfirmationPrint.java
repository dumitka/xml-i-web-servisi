package com.immunisation.officials.print;

import com.immunisation.officials.model.confirmation.Dose;
import com.immunisation.officials.model.confirmation.VaccineConfirmation;
import com.immunisation.officials.model.confirmation.VaccineDoses;

public class VaccineConfirmationPrint {
	public static void print(VaccineDoses vd) {
		for (Dose d : vd.getVaccineDoses()) {
			System.out.println("Broj_doze --> " + d.getSerialNumber());
			System.out.println("Datum_davanja --> " + d.getDateOfIssue());
			System.out.println("Serija --> "+ d.getSeries());
		}
	}
	
	public static void print(VaccineConfirmation vc) {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("POTVRDA O VAKCINACIJI");
		System.out.println("---------------------------------------------");
		System.out.println("Sifra_potvrde --> " + vc.getCode());
		GeneralUserPrint.print(vc.getUser());
		print(vc.getVaccineDoses());
		System.out.println("Naziv_vakcinea --> " + vc.getVaccine());
		System.out.println("Datum_izdavanja --> " + vc.getDateOfIssue());
		System.out.println("QR_kod --> " + vc.getQRCode());
		System.out.println("---------------------------------------------");
	}
}
