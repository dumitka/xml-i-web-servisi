package com.immunisation.officials.model.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
    "header",
    "certificateInfo",
    "user",
    "vaccinationInfo",
    "test"
})
@XmlRootElement(name = "Sertifikat")
public class DigitalGreenCertificate {
	@XmlElement(name = "Zaglavlje")
	private Header header;
	
	@XmlElement(name = "Info_sertifikat")
	private CertificateInfo certificateInfo;
	
	@XmlElement(name = "Info_korisnika")
	private GeneralUser user;
	
	@XmlElement(name = "Info_vakcinacije")
	private VaccinationInfo vaccinationInfo;
	
	@XmlElement(name = "Info_testovi")
	private TestInfo test;
}
