package com.immunisation.officials.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", propOrder = {
    "township",
    "place",
    "street",
    "number",
})
public class Address {
	@XmlElement(name = "Opstina")
	private String township; //opstina
	
	@XmlElement(name = "Mesto")
	private String place;
	
	@XmlElement(name = "Ulica")
	private String street;
	
	@XmlElement(name = "Broj")
	private String number;

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
