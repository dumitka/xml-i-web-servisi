package com.immunisation.patients.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.patients.model.types.DateAdapter;



@XmlRootElement(name = "vaccinationDate")
@XmlType(propOrder = {"naziv", "datum", "vremeSeconds"})
public class VaccinationDate {
	
	@XmlElement(name="naziv")
	public String naziv;
	
	@XmlElement(name="datum")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date datum;
	
	@XmlElement(name="vremeSeconds")
	public int vremeSeconds;

	public VaccinationDate() {
	}

	public VaccinationDate(String naziv, Date datum, int vremeSeconds) {
		super();
		this.naziv = naziv;
		this.datum = datum;
		this.vremeSeconds = vremeSeconds;
	}
	
}

