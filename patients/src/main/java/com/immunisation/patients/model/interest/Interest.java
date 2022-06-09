package com.immunisation.patients.model.interest;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.patients.model.types.Contact;
import com.immunisation.patients.model.types.DateAdapter;
import com.immunisation.patients.model.types.GeneralUser;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"code",
    "patient",
    "contact",
    "vaccinationData",
    "date"
})
@XmlRootElement(name = "Interesovanje")
public class Interest {
	@XmlElement(name = "Sifra_interesovanja", namespace = "http://www.baklavice.com/user")
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public GeneralUser getPatient() {
		return patient;
	}

	public void setPatient(GeneralUser patient) {
		this.patient = patient;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public VaccinationData getVaccinationData() {
		return vaccinationData;
	}

	public void setVaccinationData(VaccinationData vaccinationData) {
		this.vaccinationData = vaccinationData;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
