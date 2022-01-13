package com.immunisation.officials.model.green_certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
}
