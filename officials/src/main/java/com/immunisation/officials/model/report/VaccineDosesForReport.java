package com.immunisation.officials.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    "totalNumberOfGivenDoses",
    "doses",
})
@XmlRootElement(name = "Doze_vakcine")
public class VaccineDosesForReport {
	@XmlElement(name = "Ukupno_datih_doza")
	private int totalNumberOfGivenDoses;
	
	@XmlElement(name = "Doza")
	private List<DosesForReport> doses;
}
