package com.immunisation.patients.model.consent;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.patients.enums.VaccineType;
import com.immunisation.patients.model.types.DateAdapter;
import com.immunisation.patients.model.types.ExtendUser;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "patient",
    "patientAgrees",
    "vaccineType",
    "date"
})
@XmlRootElement(name = "Deo_za_pacijenta")
public class PartForPatients {
	@XmlElement(name = "Licni_podaci")
	private ExtendUser patient;
	
	@XmlElement(name = "Pacijent_je_saglasan")
	private boolean patientAgrees;
	
	@XmlElement(name = "Tip_vakcine")
	private VaccineType vaccineType;
	
	@XmlElement(name = "Datum_saglasnosti")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;  //datum saglasnosti

	public ExtendUser getPatient() {
		return patient;
	}

	public void setPatient(ExtendUser patient) {
		this.patient = patient;
	}

	public boolean isPatientAgrees() {
		return patientAgrees;
	}

	public void setPatientAgrees(boolean patientAgrees) {
		this.patientAgrees = patientAgrees;
	}

	public VaccineType getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
