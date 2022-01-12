package com.immunisation.officials.model.consent;

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
    "partForPatients",
    "partForPublicOfficial"
})
@XmlRootElement(name = "Saglasnost")
public class ConsentForVaccination {
	@XmlElement(name = "Deo_za_pacijenta")
	private PartForPatients partForPatients;
	
	@XmlElement(name = "Deo_za_radnika")
	private PartForPublicOfficial partForPublicOfficial;
}
