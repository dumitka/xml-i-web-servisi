package com.immunisation.officials.print;

import com.immunisation.officials.model.Patient;
import com.immunisation.officials.model.consent.ConsentForVaccination;
import com.immunisation.officials.model.consent.PartForPatients;
import com.immunisation.officials.model.consent.PartForPublicOfficial;

public class ConsentForVaccinationPrint {	
	public static void print(Patient p) {
		System.out.println("PACIJENT");
		System.out.println("Ime_roditelja --> " + p.getNameOfParent());
		System.out.println("Mesto_rodjenja --> " + p.getBirthPlace());
		System.out.println("Adresa --> " + p.getAddress());
		ContactPrint.print(p.getContact());
		System.out.println("Radni_status --> " + p.getEmploymentStatus());
		System.out.println("Zanimanje_zaposlenog --> " + p.getProfession());
		System.out.println("Socijalna_zastita --> " + p.isSocialCare());
		System.out.println("Sediste_socijalne_zastite --> " + p.getHeadquarterOfSocialCare());
	}
	
	public static void print(PartForPatients part) {
		System.out.println("DEO ZA PACIJENTA");
		System.out.print("Licni_podaci --> ");
		print(part.getPatient());
		System.out.println("Pacijent_je_saglasan --> " + part.isPatientAgrees());
		System.out.println("Tip_vakcine --> " + part.getVaccineType());
		System.out.println("Datum_saglasnosti --> " + part.getDate());
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
	
	public static void print(ConsentForVaccination cfv) {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("SAGLASNOST");
		System.out.println("---------------------------------------------");
		print(cfv.getPartForPatients());
		print(cfv.getPartForPublicOfficial());
		System.out.println("---------------------------------------------");
	}
}
