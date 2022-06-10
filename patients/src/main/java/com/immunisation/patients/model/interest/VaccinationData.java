package com.immunisation.patients.model.interest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.patients.enums.VaccineType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "townshipOfInstitution",
    "vaccineType",
    "bloodDonor"
})
@XmlRootElement(name = "Podaci_o_vakcinaciji", namespace = "http://www.baklavice.com/interesovanje")
public class VaccinationData {
	@XmlElement(name = "Opstina_ustanove")
	private String townshipOfInstitution;
	
	@XmlElement(name = "Tip_vakcine")
	private VaccineType vaccineType;
	
	@XmlElement(name = "Davalac_krvi")
	private boolean bloodDonor;

	public String getTownshipOfInstitution() {
		return townshipOfInstitution;
	}

	public void setTownshipOfInstitution(String townshipOfInstitution) {
		this.townshipOfInstitution = townshipOfInstitution;
	}

	public VaccineType getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}

	public boolean isBloodDonor() {
		return bloodDonor;
	}

	public void setBloodDonor(boolean bloodDonor) {
		this.bloodDonor = bloodDonor;
	}
	
	
}
