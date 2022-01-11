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

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coatOfArms",
    "title",
    "QRCode"
})
@XmlRootElement(name = "Zaglavlje")
public class Header {
	@XmlElement(name = "Grb")
	private String coatOfArms; //grb
	
	@XmlElement(name = "Naslov")
	private String title;
	
	@XmlElement(name = "QR_kod")
	private String QRCode;
}
