package com.immunisation.officials.model.vaccineinfo;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {
	}
	
	public VaccineInfo createVaccineInfo() {
		return new VaccineInfo();
	}

}
