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
    "confirmationCode",
    "patient",
    "vaccineDoses",
    "healthFacility",
    "vaccine",
    "dateOfIssue",
    "QRCode"
})
@XmlRootElement(name = "Potvrda")
public class VaccineConfirmation {
	@XmlElement(name = "Sifra_potvrde")
	private String confirmationCode; //sifra potvrde
	
	@XmlElement(name = "Info_korisnika")
	private Patient patient;
	
	@XmlElement(name = "Doze_vakcine")
	private VaccineDoses vaccineDoses;
	
	@XmlElement(name = "Zdravstvena_ustanova")
	private String healthFacility;
	
	@XmlElement(name = "Naziv_vakcine")
	private Vaccine vaccine; //naziv vakcine
	
	@XmlElement(name = "Datum_izdavanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue; //datum izdavanja
	
	@XmlElement(name = "QR_kod")
	private String QRCode;
}
