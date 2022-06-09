package com.immunisation.officials.model.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.enums.VaccineType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"manufecturerName",
		"numberOfDoses"
	})
@XmlRootElement(name = "Proizvodjac")
public class Manufacturer {
	@XmlElement(name = "Naziv_proizvodjaca")
	private VaccineType manufecturerName;
	
	@XmlElement(name = "Broj_doza")
	private int numberOfDoses;

	public VaccineType getManufecturerName() {
		return manufecturerName;
	}

	public void setManufecturerName(VaccineType manufecturerName) {
		this.manufecturerName = manufecturerName;
	}

	public int getNumberOfDoses() {
		return numberOfDoses;
	}

	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}
	
	
}
