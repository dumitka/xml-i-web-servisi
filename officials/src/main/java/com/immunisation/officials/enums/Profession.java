package com.immunisation.officials.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Profession {

	@XmlEnumValue("Zdravstvena zastita") ZDRAVSTVENA_ZASTITA,
	@XmlEnumValue("Socijalna zastita") SOCIJALNA_ZASTITA,
	@XmlEnumValue("Prosveta") PROSVETA,
	@XmlEnumValue("MUP") MUP,
	@XmlEnumValue("Vojska RS") VOJSKA,
	@XmlEnumValue("Drugo") DRUGO;
	
}
