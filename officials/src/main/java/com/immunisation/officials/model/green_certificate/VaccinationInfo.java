package com.immunisation.officials.model.green_certificate;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vaccinations"
})
@XmlRootElement(name = "Info_vakcinacije")
public class VaccinationInfo {
	@XmlElement(name = "Vakcinacije")
	List<Vaccination> vaccinations;

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
	
	
}
