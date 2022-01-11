package com.immunisation.officials.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
@XmlType(name = "TKontakt", propOrder = {
    "cellphone",
    "landline",
    "email"
})
public class Contact {
	@XmlElement(name = "Broj_mobilnog")
	private String cellphone;
	
	@XmlElement(name = "Broj_fiksnog")
	private String landline; //fiksni
	
	@XmlElement(name = "Email")
	private String email;
}
