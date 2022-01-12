package com.immunisation.officials.model.tipovi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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
}
