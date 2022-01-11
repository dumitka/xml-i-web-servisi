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
    "patient",
    "patientAgrees",
    "vaccine",
    "date"
})
@XmlRootElement(name = "Deo_za_pacijenta")
public class PartForPatients {
	@XmlElement(name = "Licni_podaci")
	private Patient patient;
	
	@XmlElement(name = "Pacijent_je_saglasan")
	private boolean patientAgrees;
	
	@XmlElement(name = "Tip_vakcine")
	private Vaccine vaccine;
	
	@XmlElement(name = "Datum_saglasnosti")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;  //datum saglasnosti
}
