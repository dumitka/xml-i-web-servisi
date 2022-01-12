package com.immunisation.officials.model.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.model.tipovi.Address;

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
    "coatOfArms",
    "institutionAdress"
})
@XmlRootElement(name = "Izdavac")
public class Publisher {
	@XmlElement(name = "Grb")
	private String coatOfArms; //grb
	
	@XmlElement(name = "Adresa_institucije")
	private Address institutionAdress;
}
