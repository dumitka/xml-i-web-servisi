package com.immunisation.officials.model.zahtev_za_sertifikat;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@SuperBuilder
//@AllArgsConstructor
//@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://www.baklavice.com/tipovi", name = "TKorisnikOpste", propOrder = {
    "citizenship",
    "residence",
    "name",
    "lastName",
    "gender",
    "birthdate",
    "document"
})
@XmlRootElement(name = "Podaci_o_licu")
public class GeneralUser {
	@XmlElement(name = "Drzavljanstvo", defaultValue="Republika Srbija")
	private String citizenship;
	
	@XmlElement(name = "Boraviste", defaultValue="Republika Srbija")
	private String residence;
	
	@XmlElement(name = "Ime")
	private String name;
	
	@XmlElement(name = "Prezime")
	private String lastName;
	
	@XmlElement(name = "Pol")
	private String gender;
	
	@XmlElement(name = "Datum_rodjenja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date birthdate;
	
	@XmlElements(value = { 
			@XmlElement(name="JMBG", 
                        type=String.class),
            @XmlElement(name="Broj_pasosa", 
                        type=String.class)})
	private String document;
}
