package com.immunisation.patients.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.immunisation.patients.model.interest.Interest;

@XmlRootElement(name = "interesovanja_collection")
public class InterestCollection {

	@XmlElementWrapper(name="Interesovanja")
	@XmlElement(name="Interesovanje")
	public Interest[] interests;
	
	public InterestCollection() {}
	
	public InterestCollection(Interest[] interests) {
		this.interests = interests;
	}
}
