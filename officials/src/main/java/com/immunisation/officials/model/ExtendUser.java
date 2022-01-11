package com.immunisation.officials.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TKorisnikSire", propOrder = {
		"nameOfParent",
	    "birthPlace",
	    "address",
	    "contact",
	    "employmentStatus",
	    "profession",
	    "socialCare",
	    "headquarterOfSocialCare"
})
public class ExtendUser extends GeneralUser {
	@XmlElement(name = "Ime_roditelja")
	private String nameOfParent;
	
	@XmlElement(name = "Mesto_rodjenja")
	private String birthPlace;
	
	@XmlElement(name = "Adresa")
	private Address address;
	
	@XmlElement(name = "Kontakt")
	private Contact contact;
	
	@XmlElement(name = "Radni_status")
	private String employmentStatus;
	
	@XmlElement(name = "Zanimanje_zaposlenog")
	private String profession;
	
	@XmlElement(name = "Socijalna_zastita")
	private boolean socialCare;
	
	@XmlElement(name = "Sediste_socijalne_zastite")
	private String headquarterOfSocialCare;
	
	
}
