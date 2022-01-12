package com.immunisation.officials.model.digitalni_sertifikat;

//import java.time.LocalDateTime;
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
    "name",
    "type",
    "manufacturer",
    "testDate",
})
@XmlRootElement(name = "Informacije")
public class Informations {
	@XmlElement(name = "Naziv")
	private String name;
	
	@XmlElement(name = "Vrsta")
	private String type;
	
	@XmlElement(name = "Proizvodjac")
	private String manufacturer;
	
	@XmlElement(name = "Datum_testiranja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date testDate;
	
}
