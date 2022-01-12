package com.immunisation.officials.model.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.enums.VaccineType;

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
}
