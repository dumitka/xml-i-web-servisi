package com.immunisation.officials.model.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.enums.VaccineType;
import com.immunisation.officials.model.tipovi.Vaccine;

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
	
	@XmlElement(name = "Zdravsvena_ustanova")
	private String healthFacility;
	
}
