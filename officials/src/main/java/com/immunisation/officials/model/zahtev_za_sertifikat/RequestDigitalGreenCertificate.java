package com.immunisation.officials.model.zahtev_za_sertifikat;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;

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
	"code",
    "statement",
    "user",
    "reasonForRequest",
    "place",
    "date"
})
@XmlRootElement(name = "Zahtev")
public class RequestDigitalGreenCertificate {
	@XmlElement(name = "Sifra_zahteva")
	private String code;
	
	@XmlAttribute(name = "Ime_dokumenta")
	private String name;
	
	@XmlElement(name = "Izjava_podnosenja_zahteva")
	private String statement;
	
	@XmlElement(name = "Podaci_o_podnosiocu")
	private GeneralUser user;
	
	@XmlElement(name = "Razlog_podnosenja_zahteva")
	private String reasonForRequest;
	
	@XmlElement(name = "Mesto_podnosenja_zahteva")
	private String place; //mjesto podnosenja zahtjeva
	
	@XmlElement(name = "Datum_podnosenja_zahteva")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date; //datum podnosenja zahtjeva
}
