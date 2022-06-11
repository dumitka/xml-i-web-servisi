package com.immunisation.officials.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.immunisation.officials.model.vaccineinfo.VaccineInfo;

@XmlRootElement(name = "vaccineinfo_collection")
public class VaccineInfoCollection {

	@XmlElementWrapper(name="VaccineInfos")
	@XmlElement(name="VaccineInfo")
	public VaccineInfo[] vaccineinfos;
	
	public VaccineInfoCollection() {}
	
	public VaccineInfoCollection(VaccineInfo[] vaccineinfos) {
		this.vaccineinfos = vaccineinfos;
	}
}
