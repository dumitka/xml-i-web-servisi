package com.immunisation.officials.model.consent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "partForPatients",
    "partForPublicOfficial"
})
@XmlRootElement(name = "Saglasnost")
public class ConsentForVaccination {
	@XmlElement(name = "Deo_za_pacijenta")
	private PartForPatients partForPatients;
	
	@XmlElement(name = "Deo_za_radnika")
	private PartForPublicOfficial partForPublicOfficial;

	public PartForPatients getPartForPatients() {
		return partForPatients;
	}

	public void setPartForPatients(PartForPatients partForPatients) {
		this.partForPatients = partForPatients;
	}

	public PartForPublicOfficial getPartForPublicOfficial() {
		return partForPublicOfficial;
	}

	public void setPartForPublicOfficial(PartForPublicOfficial partForPublicOfficial) {
		this.partForPublicOfficial = partForPublicOfficial;
	}
	
	
}
