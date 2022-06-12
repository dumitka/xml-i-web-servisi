package com.immunisation.officials.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunisation.officials.model.consent.PartForPublicOfficial;

@XmlRootElement(name = "ConsentHWPart")
@XmlType(propOrder = {"Id", "Deo_za_pacijenta"})
public class ConsentHWPart {
	private String Id;
	private PartForPublicOfficial Deo_za_pacijenta;
	
	
	public ConsentHWPart(String Id, PartForPublicOfficial Deo_za_pacijenta) {
		super();
		this.Id = Id;
		this.Deo_za_pacijenta = Deo_za_pacijenta;
	}


	public ConsentHWPart() {
		super();
	}

	@XmlElement
	public String getId() {
		return Id;
	}


	public void setId(String Id) {
		this.Id = Id;
	}

	@XmlElement
	public PartForPublicOfficial getDeo_za_pacijenta() {
		return Deo_za_pacijenta;
	}


	public void setDeo_za_pacijenta(PartForPublicOfficial Deo_za_pacijenta) {
		this.Deo_za_pacijenta = Deo_za_pacijenta;
	}
	
	
	
	
}
