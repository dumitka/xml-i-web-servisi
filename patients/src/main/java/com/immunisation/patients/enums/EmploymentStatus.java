package com.immunisation.patients.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum EmploymentStatus {

	@XmlEnumValue("Zaposlen") ZAPOSLEN,
	@XmlEnumValue("Nezaposlen") NEZAPOSLEN,
	@XmlEnumValue("Penzioner") PENZIONER,
	@XmlEnumValue("Ucenik") UCENIK,
	@XmlEnumValue("Student") STUDENT,
	@XmlEnumValue("Dete") SETE;
	
}
