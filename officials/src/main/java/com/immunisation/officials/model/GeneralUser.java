package com.immunisation.officials.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
//@SuperBuilder
//@AllArgsConstructor
//@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TKorisnikOpste", propOrder = {
    "citizenship",
    "residence",
    "name",
    "lastName",
    "gender",
    "birthdate",
    "UPIN",
    "passportNumber"
})
public class GeneralUser {
	@XmlElement(name = "Drzavljanstvo")
	private String citizenship;
	
	@XmlElement(name = "Boraviste")
	private String residence;
	
	@XmlElement(name = "Ime")
	private String name;
	
	@XmlElement(name = "Prezime")
	private String lastName;
	
	@XmlElement(name = "Pol")
	private String gender;
	
	@XmlElement(name = "Datum_rodjenja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date birthdate;
	
	@XmlElement(name = "JMBG")
	private String UPIN; //Unique Personal Identification Number il' ti JMBG
	
	@XmlElement(name = "Broj_pasosa")
	private String passportNumber;
	
	
}
