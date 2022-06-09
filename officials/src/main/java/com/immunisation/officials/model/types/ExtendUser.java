package com.immunisation.officials.model.types;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.enums.EmploymentStatus;
import com.immunisation.officials.enums.Profession;


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
	private EmploymentStatus employmentStatus;
	
	@XmlElement(name = "Zanimanje_zaposlenog")
	private Profession profession;
	
	@XmlElement(name = "Socijalna_zastita")
	private boolean socialCare;
	
	@XmlElement(name = "Sediste_socijalne_zastite")
	private String headquarterOfSocialCare;

	public String getNameOfParent() {
		return nameOfParent;
	}

	public void setNameOfParent(String nameOfParent) {
		this.nameOfParent = nameOfParent;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public boolean isSocialCare() {
		return socialCare;
	}

	public void setSocialCare(boolean socialCare) {
		this.socialCare = socialCare;
	}

	public String getHeadquarterOfSocialCare() {
		return headquarterOfSocialCare;
	}

	public void setHeadquarterOfSocialCare(String headquarterOfSocialCare) {
		this.headquarterOfSocialCare = headquarterOfSocialCare;
	}
	
	
}
