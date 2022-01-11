package com.immunisation.officials.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
    "healthFacility",
    "vaccinationPoint",
    "doctorData",
    "namesOfVaccine",
    "datesOfVaccination",
    "waysOfGivingTheVaccine",
    "limbs",
    "vaccineSeries",
    "manufacturers",
    "sideEffects",
    "temporaryContractions",
    "permanentContractions",
})
@XmlRootElement(name = "Deo_za_radnika")
public class PartForPublicOfficial {
	
	@XmlElement(name = "Zdravstvena_ustanova")
	private String healthFacility;
	
	@XmlElement(name = "Vakcinacijski_punkt")
	private String vaccinationPoint;
	
	@XmlElement(name = "Podaci_o_lekaru")
	private String doctorData;
	
	
	@XmlElement(name = "Naziv_vakcine")
	private List<String> namesOfVaccine;
	
	@XmlElement(name = "Datum_davanja_vakcine")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private List<Date> datesOfVaccination;
	
	@XmlElement(name = "Nacin_davanja_vakcine")
	private List<String> waysOfGivingTheVaccine;
	
	@XmlElement(name = "Ekstremitet")
	private List<String> limbs;
	
	@XmlElement(name = "Serija_vakcine")
	private List<String> vaccineSeries;
	
	@XmlElement(name = "Proizvodjac")
	private List<String> manufacturers;
	
	@XmlElement(name = "Nezeljena_reakcija")
	private List<String> sideEffects;
	
	
	@XmlElement(name = "Privremene_kontraindikacije")
	private String temporaryContractions; //privremene kontrakcije
	
	@XmlElement(name = "Trajne_kontraindikacije")
	private String permanentContractions;
}
