package com.immunisation.officials.print;

import com.immunisation.officials.model.types.Contact;

public class ContactPrint {
	public static void print(Contact contact) {
		System.out.println("KONTAKT");
		System.out.println("Broj_mobilnog --> " + contact.getCellphone());
		System.out.println("Broj_fixnog --> " + contact.getLandline());
		System.out.println("Email --> " + contact.getEmail());
	}
}
