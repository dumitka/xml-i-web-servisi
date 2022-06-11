package com.immunisation.officials.dto;

import java.time.LocalTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "vaccinationDate")
@XmlType(propOrder = {"naziv", "naziv", "time"})
public class VaccinationDate {
	
	private String naziv;
	private Date datum;
	private LocalTime time;
	
	public VaccinationDate() {
		
	}

	public VaccinationDate(String naziv, Date datum, LocalTime time) {
		super();
		this.naziv = naziv;
		this.datum = datum;
		this.time = time;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
}
