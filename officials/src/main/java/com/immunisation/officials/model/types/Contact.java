package com.immunisation.officials.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

//@Builder
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://www.baklavice.com/tipovi", name = "TKontakt", propOrder = {
    "cellphone",
    "landline",
    "email"
})
@XmlRootElement(name = "Kontakt")
public class Contact {
	@XmlElement(name = "Broj_mobilnog")
	private String cellphone;
	
	@XmlElement(name = "Broj_fiksnog")
	private String landline; //fiksni
	
	@XmlElement(name = "Email")
	private String email;
}
