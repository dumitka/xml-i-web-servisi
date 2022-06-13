package com.immunisation.officials.model.confirmation;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
	
	@XmlAttribute(name = "vocab")
    @XmlSchemaType(name = "anySimpleType")
    protected String vocab;
    @XmlAttribute(name = "about")
    @XmlSchemaType(name = "anySimpleType")
    protected String about;
    @XmlAttribute(name = "rel")
    @XmlSchemaType(name = "anySimpleType")
    protected String rel;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anySimpleType")
    protected String href;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
	
	public String getVocab() {
		return vocab;
	}

	public void setVocab(String vocab) {
		this.vocab = vocab;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
