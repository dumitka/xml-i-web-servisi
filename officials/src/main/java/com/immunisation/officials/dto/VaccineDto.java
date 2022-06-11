package com.immunisation.officials.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vaccdto")
@XmlType(propOrder = {"name", "kolicina"})
public class VaccineDto {

	private String name;
	private Integer kolicina;
	
	public VaccineDto() {
	}

	public VaccineDto(String name, Integer kolicina) {
		super();
		this.name = name;
		this.kolicina = kolicina;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	
	
	
}
