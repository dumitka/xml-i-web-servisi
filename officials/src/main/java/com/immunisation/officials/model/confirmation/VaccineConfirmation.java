package com.immunisation.officials.model.confirmation;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.enums.VaccineType;
import com.immunisation.officials.model.DateAdapter;
import com.immunisation.officials.model.types.GeneralUser;

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
    "user",
    "vaccineDoses",
    "vaccine",
    "dateOfIssue",
    "QRCode"
})
@XmlRootElement(name = "Potvrda")
public class VaccineConfirmation {
	@XmlElement(name = "Sifra_potvrde")
	private String code;
	
	@XmlElement(name = "Info_korisnika")
	private GeneralUser user;
	
	@XmlElement(name = "Doze_vakcine")
	private VaccineDoses vaccineDoses;
	
	@XmlElement(name = "Naziv_vakcine")
	private VaccineType vaccine; 
	
	@XmlElement(name = "Datum_izdavanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue; 
	
	@XmlElement(name = "QR_kod")
	private String QRCode;
}