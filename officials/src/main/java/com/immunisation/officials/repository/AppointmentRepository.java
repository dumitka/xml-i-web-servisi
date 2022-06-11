package com.immunisation.officials.repository;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.immunisation.officials.model.appointment.Appointment;
import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository {
	
	private String collectionUri = "/db/eUprava/appointment";
	
	@Autowired
    private ExistManager existManager;
	
	//kreiranje
	public void save(Appointment app) throws Exception {
		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.appointment");
		
		Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        
        marshaller.marshal(app, sw);

        existManager.storeFromText(collectionUri, app.getId() + ".xml", sw.toString());
	}
	

	//search po tome da li je rezervisan
//	[tip~=posta]
	public Appointment[] searchByRezervisan() throws Exception {
		String query = "[rezervisan~=false]";
		
		String queryPart = "for $x in collection() ";
		String wherePart = "where $x//*/text()[contains(lower-case(.), '" 
							+ query.toLowerCase()
							+ "')] return $x";
		String[] xmls = existManager.retrieve(collectionUri, queryPart + wherePart);
		Appointment[] appointments = new Appointment[xmls.length];
		
		int i = 0;
		for (String xml : xmls) {
			appointments[i] = createAppointmentFromString(xml);
		}
 		
		return appointments;
	}
	
	//rezervisanje odredjenog
	public void rezervisiAppointment(String id) throws Exception {

		existManager.update(0, collectionUri, id + ".xml", "//*:rezervisan", String.valueOf(true));
	}

	//getById
	public Appointment findById(String id) throws Exception {
		String app = existManager.load(collectionUri, id + ".xml");
    	
    	JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.appointment");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader sr = new StringReader(app);

        Appointment appInstance = (Appointment) unmarshaller.unmarshal(sr);
        return appInstance;
	}
	

	private Appointment createAppointmentFromString(String xml) throws JAXBException {
		StringReader stringReader = new StringReader(xml);

        JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.appointment");
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (Appointment) unmarshaller.unmarshal(stringReader);
	}
	
	
}
