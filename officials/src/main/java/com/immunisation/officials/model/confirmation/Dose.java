package com.immunisation.officials.model.confirmation;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateOfIssue",
    "series"
})
@XmlRootElement(name = "Doza")
public class Dose {
	@XmlAttribute(name = "Broj_doze", required = true)
	private int serialNumber;
	
	@XmlElement(name = "Datum_davanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue;
	
	@XmlElement(name = "Serija")
	private String series;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	
}
