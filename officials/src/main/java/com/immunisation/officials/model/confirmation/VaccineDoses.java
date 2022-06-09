package com.immunisation.officials.model.confirmation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vaccineDoses"
})
@XmlRootElement(name = "Doze_vakcine")
public class VaccineDoses {
	@XmlElement(name = "Doza")
	List<Dose> vaccineDoses;

	public List<Dose> getVaccineDoses() {
		return vaccineDoses;
	}

	public void setVaccineDoses(List<Dose> vaccineDoses) {
		this.vaccineDoses = vaccineDoses;
	}
	
	
}
