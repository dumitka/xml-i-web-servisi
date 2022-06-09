package com.immunisation.officials.model.consent;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nameOfVaccine",
    "dateOfVaccination",
    "wayOfGivingTheVaccine",
    "limb",
    "vaccineSerie",
    "manufacturer",
    "sideEffect"
})
@XmlRootElement(name = "Primljena_vakcina")
public class ReceivedVaccine {

	@XmlElement(name = "Naziv_vakcine")
	private String nameOfVaccine;
	
	@XmlElement(name = "Datum_davanja_vakcine")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfVaccination;
	
	@XmlElement(name = "Nacin_davanja_vakcine")
	private String wayOfGivingTheVaccine;
	
	@XmlElement(name = "Ekstremitet")
	private String limb;
	
	@XmlElement(name = "Serija_vakcine")
	private String vaccineSerie;
	
	@XmlElement(name = "Proizvodjac")
	private String manufacturer;
	
	@XmlElement(name = "Nezeljena_reakcija")
	private String sideEffect;

	public String getNameOfVaccine() {
		return nameOfVaccine;
	}

	public void setNameOfVaccine(String nameOfVaccine) {
		this.nameOfVaccine = nameOfVaccine;
	}

	public Date getDateOfVaccination() {
		return dateOfVaccination;
	}

	public void setDateOfVaccination(Date dateOfVaccination) {
		this.dateOfVaccination = dateOfVaccination;
	}

	public String getWayOfGivingTheVaccine() {
		return wayOfGivingTheVaccine;
	}

	public void setWayOfGivingTheVaccine(String wayOfGivingTheVaccine) {
		this.wayOfGivingTheVaccine = wayOfGivingTheVaccine;
	}

	public String getLimb() {
		return limb;
	}

	public void setLimb(String limb) {
		this.limb = limb;
	}

	public String getVaccineSerie() {
		return vaccineSerie;
	}

	public void setVaccineSerie(String vaccineSerie) {
		this.vaccineSerie = vaccineSerie;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSideEffect() {
		return sideEffect;
	}

	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	
	
	
}
