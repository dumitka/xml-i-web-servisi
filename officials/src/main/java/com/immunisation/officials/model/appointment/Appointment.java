package com.immunisation.officials.model.appointment;

import java.time.LocalTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointment", propOrder = {
		"id",
		"datum",
		"vreme",
		"rezervisan"
})
@XmlRootElement(name = "appointment", namespace = "http://www.baklavice.com/appointment")
public class Appointment {
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	protected String id;
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	protected Date datum;
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	protected LocalTime vreme;
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment")
	protected Boolean rezervisan;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public LocalTime getVreme() {
		return vreme;
	}

	public void setVreme(LocalTime vreme) {
		this.vreme = vreme;
	}

	public Boolean getRezervisan() {
		return rezervisan;
	}

	public void setRezervisan(Boolean rezervisan) {
		this.rezervisan = rezervisan;
	}

}
