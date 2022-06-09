package com.immunisation.officials.model.consent;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "healthFacility",
    "vaccinationPoint",
    "doctorData",
    "receivedVaccines",
    "temporaryContractions",
    "permanentContractions",
})
@XmlRootElement(name = "Deo_za_radnika")
public class PartForPublicOfficial {
	
	@XmlElement(name = "Zdravstvena_ustanova")
	private String healthFacility;
	
	@XmlElement(name = "Vakcinacijski_punkt")
	private String vaccinationPoint;
	
	@XmlElement(name = "Podaci_o_lekaru")
	private String doctorData;
	
	@XmlElementWrapper(name="Primljene_vakcine_info")
	@XmlElement(name = "Primljena_vakcina")
	private List<ReceivedVaccine> receivedVaccines;
	
	@XmlElement(name = "Privremene_kontraindikacije")
	private String temporaryContractions; //privremene kontrakcije
	
	@XmlElement(name = "Trajne_kontraindikacije")
	private String permanentContractions;

	public String getHealthFacility() {
		return healthFacility;
	}

	public void setHealthFacility(String healthFacility) {
		this.healthFacility = healthFacility;
	}

	public String getVaccinationPoint() {
		return vaccinationPoint;
	}

	public void setVaccinationPoint(String vaccinationPoint) {
		this.vaccinationPoint = vaccinationPoint;
	}

	public String getDoctorData() {
		return doctorData;
	}

	public void setDoctorData(String doctorData) {
		this.doctorData = doctorData;
	}

	public List<ReceivedVaccine> getReceivedVaccines() {
		return receivedVaccines;
	}

	public void setReceivedVaccines(List<ReceivedVaccine> receivedVaccines) {
		this.receivedVaccines = receivedVaccines;
	}

	public String getTemporaryContractions() {
		return temporaryContractions;
	}

	public void setTemporaryContractions(String temporaryContractions) {
		this.temporaryContractions = temporaryContractions;
	}

	public String getPermanentContractions() {
		return permanentContractions;
	}

	public void setPermanentContractions(String permanentContractions) {
		this.permanentContractions = permanentContractions;
	}
	
	
}
