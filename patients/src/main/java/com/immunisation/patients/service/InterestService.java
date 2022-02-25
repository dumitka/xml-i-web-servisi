package com.immunisation.patients.service;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.patients.jaxb.JaxB;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.repository.InterestRepository;


@Service
public class InterestService {
	
	@Autowired
	private JaxB jaxb;
	
	@Autowired 
	private InterestRepository repository;

	public InterestCollection getAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException, JAXBException, XMLDBException {
		Interest[] interests = repository.getAll();
		
		InterestCollection collection = new InterestCollection(interests);
		
		return collection;
	}

	public void saveInterest(String interest) {
		// TODO Auto-generated method stub
		
	}

}
