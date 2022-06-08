package com.immunisation.patients.model.consent;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
}
