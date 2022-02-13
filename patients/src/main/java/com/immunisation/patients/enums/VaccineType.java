package com.immunisation.patients.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum VaccineType {
	
	@XmlEnumValue("Pfizer-BioNTech") PFIZER,
    @XmlEnumValue("Sputnik V") SPUTNIK,
    @XmlEnumValue("Sinopharm") SINOPHARM,
    @XmlEnumValue("AstraZeneca") ASTRA_ZENECA,
    @XmlEnumValue("Moderna") MODERNA;
	
}