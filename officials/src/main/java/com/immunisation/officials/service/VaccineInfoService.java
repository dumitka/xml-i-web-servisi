package com.immunisation.officials.service;

import javax.xml.bind.JAXBException;

import com.immunisation.officials.dto.VaccineInfoCollection;
import com.immunisation.officials.jaxb.JaxB;
import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.repository.VaccineInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

@Service
public class VaccineInfoService {

	@Autowired
	private JaxB jaxb;
	
	@Autowired 
	private VaccineInfoRepository repository;
	
	//getuj sve
	public VaccineInfoCollection getAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException, JAXBException, XMLDBException {
		VaccineInfo[] infos = repository.getAll();
		
		VaccineInfoCollection collection = new VaccineInfoCollection(infos);
		
		return collection;
	}
	
	//kreiraj novu
	public void save(VaccineInfo vaccInfo) throws Exception {
		repository.save(vaccInfo);
	}

	//get by naziv
	public VaccineInfo getByNaziv(String naziv) throws Exception {
		return repository.findByNaziv(naziv);
	}
	
	//dodaj nove slobodne
	public void dodajNoveVakcine(String naziv, Integer kolicina) throws Exception {
		repository.dodajNoveVakcine(naziv, kolicina);
	}
	
	//rezervisi jednu TREBACE PRI NALAZENJU TERMINA
	public void rezervisiJednuDozu(String vaccInfoUri) throws Exception {
		repository.rezervisiJednu(vaccInfoUri);
	}
	
	//smanji  rezervisane za jednu  TREBACE PRI VAKCINACIJI
	public void smanjiRezervisaneZaJedan(String vaccInfoUri) throws Exception {
		repository.obaviVakcinaciju(vaccInfoUri);
	}
}
