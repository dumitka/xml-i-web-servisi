package com.immunisation.patients.model.consent;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.patients.model.types.DateAdapter;

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
	
}
