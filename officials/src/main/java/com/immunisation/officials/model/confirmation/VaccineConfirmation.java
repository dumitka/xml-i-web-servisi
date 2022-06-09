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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public GeneralUser getUser() {
		return user;
	}

	public void setUser(GeneralUser user) {
		this.user = user;
	}

	public VaccineDoses getVaccineDoses() {
		return vaccineDoses;
	}

	public void setVaccineDoses(VaccineDoses vaccineDoses) {
		this.vaccineDoses = vaccineDoses;
	}

	public VaccineType getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineType vaccine) {
		this.vaccine = vaccine;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getQRCode() {
		return QRCode;
	}

	public void setQRCode(String qRCode) {
		QRCode = qRCode;
	}
	
	
}
