package com.immunisation.officials.repository;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.immunisation.officials.model.appointment.Appointment;
import com.immunisation.officials.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository {
	
	private String collectionUri = "/db/eUprava/appointment";
	
	@Autowired
    private ExistManager existManager;
	
	//kreiranje
	
	//rezervisanje odredjenog
	public Appointment findById(String id) throws Exception {
		String app = existManager.load(collectionUri, id + ".xml");
    	
    	JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.appointment");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader sr = new StringReader(app);

        Appointment appInstance = (Appointment) unmarshaller.unmarshal(sr);
        return appInstance;
	}
	
	//search po tome da li je rezervisan
}
