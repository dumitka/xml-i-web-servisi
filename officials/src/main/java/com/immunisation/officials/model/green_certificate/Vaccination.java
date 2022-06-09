package com.immunisation.officials.model.green_certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.enums.VaccineType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vaccineType",
    "manufacturer",
    "series",
    "healthFacility",
})
@XmlRootElement(name = "Vakcinacije")
public class Vaccination {
	@XmlAttribute(name = "Doza", required = true)
	private int dose;
	
	@XmlElement(name = "Tip")
	private VaccineType vaccineType;
	
	@XmlElement(name = "Proizvodjac")
	private String manufacturer;
	
	@XmlElement(name = "Serija")
	private String series;
	
	@XmlElement(name = "Zdravsvena_ustanova") //? TODO
	private String healthFacility;

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public VaccineType getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getHealthFacility() {
		return healthFacility;
	}

	public void setHealthFacility(String healthFacility) {
		this.healthFacility = healthFacility;
	}
	
	
	
}
