package com.immunisation.officials.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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

	public int getTotalNumberOfGivenDoses() {
		return totalNumberOfGivenDoses;
	}

	public void setTotalNumberOfGivenDoses(int totalNumberOfGivenDoses) {
		this.totalNumberOfGivenDoses = totalNumberOfGivenDoses;
	}

	public List<DosesForReport> getDoses() {
		return doses;
	}

	public void setDoses(List<DosesForReport> doses) {
		this.doses = doses;
	}
	
}
