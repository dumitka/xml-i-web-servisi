package com.immunisation.officials.model;

import java.time.LocalDateTime;
import java.util.Date;

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
    "statement",
    "patient",
    "reasonForRequest",
    "place",
    "date"
})
@XmlRootElement(name = "Zahtev")
public class RequestDigitalGreenCertificate {
	
	@XmlElement(name = "Izjava_podnosenja_zahteva")
	private String statement;
	
	@XmlElement(name = "Podaci_o_podnosiocu")
	private Patient patient;
	
	@XmlElement(name = "Razlog_podnosenja_zahteva")
	private String reasonForRequest;
	
	@XmlElement(name = "Mesto_podnosenja_zahteva")
	private String place; //mjesto podnosenja zahtjeva
	
	@XmlElement(name = "Datum_podnosenja_zahteva")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date; //datum podnosenja zahtjeva
}
