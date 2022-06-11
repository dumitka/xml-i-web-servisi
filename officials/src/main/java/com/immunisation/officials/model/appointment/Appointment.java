package com.immunisation.officials.model.appointment;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointment", propOrder = {
		"id",
		"datum",
		"vremeSeconds",
		"rezervisan"
})
@XmlRootElement(name = "appointment", namespace = "http://www.baklavice.com/appointment")
public class Appointment {
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	protected String id;
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date datum;
	
	@XmlElement(namespace = "http://www.baklavice.com/appointment", required = true)
	protected int vremeSeconds;
	
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


	public int getVremeSeconds() {
		return vremeSeconds;
	}

	public void setVremeSeconds(int i) {
		this.vremeSeconds = i;
	}

	public Boolean getRezervisan() {
		return rezervisan;
	}

	public void setRezervisan(Boolean rezervisan) {
		this.rezervisan = rezervisan;
	}

}
