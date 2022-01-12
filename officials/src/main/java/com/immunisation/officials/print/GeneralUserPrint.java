package com.immunisation.officials.print;

import com.immunisation.officials.model.tipovi.GeneralUser;

public class GeneralUserPrint {
	public static void print(GeneralUser user) {
		System.out.println("GENERAL USER");
		System.out.println("Drzavljanstvo --> " + user.getCitizenship());
		System.out.println("Boraviste --> " + user.getResidence());
		System.out.println("Ime --> " + user.getName());
		System.out.println("Prezime --> " + user.getLastName());
		System.out.println("Pol --> " + user.getGender());
		System.out.println("Datum_rodjenja --> " + user.getBirthdate());
		System.out.println("Licni dokument --> " + user.getDocument());
	}
}
