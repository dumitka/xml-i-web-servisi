package com.immunisation.officials.model.interesovanje;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;
import com.immunisation.officials.model.tipovi.Contact;
import com.immunisation.officials.model.tipovi.GeneralUser;

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
	"code",
    "patient",
    "contact",
    "vaccinationData",
    "date"
})
@XmlRootElement(name = "Interesovanje")
public class RequestVaccination {
	@XmlElement(name = "Sifra_interesovanja")
	private int code;
	
	@XmlElement(name = "Podaci_o_licu")
	private GeneralUser patient;
	
	@XmlElement(name = "Kontakt")
	private Contact contact;
	
	@XmlElement(name = "Podaci_o_vakcinaciji")
	private VaccinationData vaccinationData;
	
	@XmlElement(name = "Datum_interesovanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date; //datum interesovanja
}
