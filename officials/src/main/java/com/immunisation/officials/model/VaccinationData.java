package com.immunisation.officials.model;

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

//@Builder
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "townshipOfInstitution",
    "vaccine",
    "bloodDonor"
})
@XmlRootElement(name = "Podaci_o_vakcinaciji")
public class VaccinationData {
	@XmlElement(name = "Opstina_ustanove")
	private String townshipOfInstitution;
	
	@XmlElement(name = "Tip_vakcine")
	private String vaccine;
	
	@XmlElement(name = "Davalac_krvi")
	private boolean bloodDonor;
}
