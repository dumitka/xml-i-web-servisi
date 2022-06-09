package com.immunisation.officials.model.green_certificate;

//import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "certificateNumber",
    "dateOfIssue"
})
@XmlRootElement(name = "Info_sertifikat")
public class CertificateInfo {
	@XmlElement(name = "Broj_sertifikata")
	private String certificateNumber;
	
	@XmlElement(name = "Datum_izdavanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue;

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	
}
