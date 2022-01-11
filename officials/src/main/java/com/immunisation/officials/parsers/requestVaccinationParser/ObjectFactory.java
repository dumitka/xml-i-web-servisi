package com.immunisation.officials.parsers.requestVaccinationParser;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.immunisation.officials.model.Contact;
import com.immunisation.officials.model.GeneralUser;
import com.immunisation.officials.model.RequestVaccination;
import com.immunisation.officials.model.VaccinationData;
//import com.immunisation.officials.model.Vaccine;

@XmlRegistry
public class ObjectFactory {
    private final static QName _RequestVaccination_QNAME = new QName("http://www.baklavice.com/interesovanje", "Interesovanje");

	
	 public ObjectFactory() {}
	 
	 public RequestVaccination createRequestVaccination() {
		return new RequestVaccination();
	 }
	 
	 public GeneralUser createPatient() {
		 return new GeneralUser();
	 }
	 
	 public Contact createContact() {
		 return new Contact();
	 }
	 
	 public VaccinationData createVaccinationData() {
		 return new VaccinationData();
	 }
	 
	 /*
	 public Vaccine createVaccine() {
		 return new Vaccine();
	 }
	 
	 
	 @XmlElementDecl(namespace = "http://www.baklavice.com/interesovanje", name = "Interesovanje")
	    public JAXBElement<Vaccine> createOdslusanPredmet(Vaccine value) {
	        return new JAXBElement<Vaccine>(_RequestVaccination_QNAME, Vaccine.class, null, value);
	    }
	    
	 */
	 
	 @XmlElementDecl(namespace = "http://www.baklavice.com/interesovanje", name = "Interesovanje")
	    public JAXBElement<VaccinationData> createOdslusanPredmet(VaccinationData value) {
	        return new JAXBElement<VaccinationData>(_RequestVaccination_QNAME, VaccinationData.class, null, value);
	    }
}
