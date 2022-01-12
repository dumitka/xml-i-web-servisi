package com.immunisation.officials.model.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
    "numberOfGivenDoses"
})
@XmlRootElement(name = "Doze_vakcine")
public class DosesForReport {
	@XmlAttribute(name = "Redni_broj", required = true)
	private int ordinalNumber;
	
	@XmlElement(name = "Broj_datih_doza")
	private int numberOfGivenDoses;
}
