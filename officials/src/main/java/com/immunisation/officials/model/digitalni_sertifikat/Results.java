package com.immunisation.officials.model.digitalni_sertifikat;

//import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.tipovi.Address;
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
    "description",
    "lab",
    "resultsDate"
})
@XmlRootElement(name = "Rezultati")
public class Results {
	@XmlElement(name = "Opis")
	private String description;
	
	@XmlElement(name = "Laboratorija")
	private Address lab;
	
	@XmlElement(name = "Datum_rezultata")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date resultsDate;
}
