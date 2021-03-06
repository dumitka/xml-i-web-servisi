package com.immunisation.patients.model.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://www.baklavice.com/tipovi", name = "TKorisnikOpste", propOrder = {
    "citizenship",
    "residence",
    "name",
    "lastName",
    "gender",
    "birthdate",
    "jmbg"
})
@XmlRootElement(name = "Podaci_o_licu", namespace = "http://www.baklavice.com/tipovi")
public class GeneralUser {
	@XmlElement(name = "Drzavljanstvo", defaultValue="Republika Srbija")
	private String citizenship;
	
	@XmlElement(name = "Boraviste", defaultValue="Republika Srbija")
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
	
//	@XmlElements(value = { 
//			@XmlElement(name="JMBG", 
//                        type=String.class),
//            @XmlElement(name="Broj_pasosa", 
//                        type=String.class)})
//	private String document;

	@XmlElement(name = "JMBG")
	private String jmbg;
	
	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	
}
