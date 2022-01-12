package com.immunisation.officials.print;

import com.immunisation.officials.model.interest.Interest;
import com.immunisation.officials.model.interest.VaccinationData;

public class InterestPrint {
	public static void print(VaccinationData data) {
		System.out.println("PODACI O VAKCINACIJI");
		System.out.println("Opstina_ustanove --> " + data.getTownshipOfInstitution());
		System.out.println("Tip_vakcine --> " + data.getVaccineType());
		System.out.println("Davalac_krvi --> " + data.isBloodDonor());
	}
	
	public static void print(Interest i) {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("INTERESOVANJE");
		System.out.println("---------------------------------------------");
		System.out.println("Sifra_interesovanja --> " + i.getCode());
		GeneralUserPrint.print(i.getPatient());
		ContactPrint.print(i.getContact());
		print(i.getVaccinationData());
		System.out.println("Datum_interesovanja --> " + i.getDate());
		System.out.println("---------------------------------------------");
	}
}
