package com.immunisation.officials.model.potvrda;

import java.time.LocalDateTime;
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
}
