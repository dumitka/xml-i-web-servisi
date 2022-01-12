package com.immunisation.officials.model.izvestaj;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
	"period",
    "numberOfInterests",
    "requestDigitalGreenCertificate",
    "digitalGreenCertificate",
    "vaccineDosesForReport",
    "distributionOfManufacturer",
    "dateOfIssue"
})
@XmlRootElement(name = "Izvestaj")
public class Report {
	@XmlElement(name = "Sifra_izvestaja", required = true)
	private String code;
	
	@XmlElement(name = "Period")
	private Period period;
	
	@XmlElement(name = "Broj_interesovanja")
	private int numberOfInterests;
	
	@XmlElement(name = "Zahtevi_za_sertifikat")
	private int requestDigitalGreenCertificate;
	
	@XmlElement(name = "Izdati_sertifikati")
	private int digitalGreenCertificate;
	
	@XmlElement(name = "Doze_vakcine")
	private VaccineDosesForReport vaccineDosesForReport;
	
	@XmlElement(name = "Raspodela_proizvodjaca")
	private DistributionOfManufacturer distributionOfManufacturer;
	
	@XmlElement(name = "Datum_izdavanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue;
}
