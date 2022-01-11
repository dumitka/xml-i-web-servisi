package com.immunisation.officials.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
@XmlType(name = "Vaccine")
@XmlRootElement(name = "Proizvodjac")
public class Manufacturer {
	//private Vaccine vaccine;
	
	@XmlAttribute(name = "Broj_doza", required = true)
	private int numberOfDoses;
}
