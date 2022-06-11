package com.immunisation.officials.model.appointment;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {
	}
	
	public Appointment createAppointment() {
		return new Appointment();
	}

}
