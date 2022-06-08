package com.immunisation.officials.model.green_certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.model.types.GeneralUser;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "certificateInfo",
    "user",
    "vaccinationInfo",
})
@XmlRootElement(name = "Sertifikat")
public class DigitalGreenCertificate {
	@XmlElement(name = "Info_sertifikat")
	private CertificateInfo certificateInfo;
	
	@XmlElement(name = "Info_korisnika")
	private GeneralUser user;
	
	@XmlElement(name = "Info_vakcinacije")
	private VaccinationInfo vaccinationInfo;

	public CertificateInfo getCertificateInfo() {
		return certificateInfo;
	}

	public void setCertificateInfo(CertificateInfo certificateInfo) {
		this.certificateInfo = certificateInfo;
	}

	public GeneralUser getUser() {
		return user;
	}

	public void setUser(GeneralUser user) {
		this.user = user;
	}

	public VaccinationInfo getVaccinationInfo() {
		return vaccinationInfo;
	}

	public void setVaccinationInfo(VaccinationInfo vaccinationInfo) {
		this.vaccinationInfo = vaccinationInfo;
	}
	
	
}
