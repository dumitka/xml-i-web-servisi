package com.immunisation.officials.model.vaccineinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vaccineinfo", propOrder = {
    "naziv",
    "slobodnih",
    "rezervisanih"
})
@XmlRootElement(name = "vaccineinfo", namespace = "http://www.baklavice.com/vaccineinfo")
public class VaccineInfo {

	@XmlElement(namespace = "http://www.baklavice.com/vaccineinfo", required = true)
	protected String naziv;
	
	@XmlElement(namespace = "http://www.baklavice.com/vaccineinfo", required = true)
	protected int slobodnih;
	
	@XmlElement(namespace = "http://www.baklavice.com/vaccineinfo", required = true)
	protected int rezervisanih;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSlobodnih() {
		return slobodnih;
	}

	public void setSlobodnih(int slobodnih) {
		this.slobodnih = slobodnih;
	}

	public int getRezervisanih() {
		return rezervisanih;
	}

	public void setRezervisanih(int rezervisanih) {
		this.rezervisanih = rezervisanih;
	}
	
	
}
