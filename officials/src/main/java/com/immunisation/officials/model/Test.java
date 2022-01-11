package com.immunisation.officials.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
    "informations",
    "results"
})
@XmlRootElement(name = "Test")
public class Test {
	@XmlAttribute(name = "Broj", required = true)
	private int number;
	
	@XmlElement(name = "Informacije")
	private Informations informations;
	
	@XmlElement(name = "Rezultati")
	private Results results;
}
