package com.immunisation.officials.repository;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

@Repository
public class VaccineInfoRepository {
	
	private String collectionUri = "/db/eUprava/vaccineinfo";

    @Autowired
    private ExistManager existManager;
	
	
    //get by naziv
    public VaccineInfo findByNaziv(String naziv) throws Exception {
    	String vInfo = existManager.load(collectionUri, naziv + ".xml");
    	
    	JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.vaccineinfo");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader sr = new StringReader(vInfo);

        VaccineInfo vInfoInstance = (VaccineInfo) unmarshaller.unmarshal(sr);
        return vInfoInstance;
    }
    
    //getuj sve
    public VaccineInfo[] getAll() throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
    	String[] xmldocs = existManager.loadXmlDocsToCollection(collectionUri);
    	
    	VaccineInfo[] infos = new VaccineInfo[xmldocs.length];
    	
    	for(int i = 0; i<xmldocs.length; i++) {
    		infos[i] = converStringToVaccineInfo(xmldocs[i]);
    	}
    	
    	return infos;
    }
    
	
//    public void saveInterest(String text, String docUri) throws Exception {
//		existManager.storeFromText(collectionUri, docUri + ".xml", text);
//	}
    
  //kreiraj novu(za db runner npr)
    public void save(VaccineInfo vaccineInfo) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.vaccineinfo");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        marshaller.marshal(vaccineInfo, sw);

        existManager.storeFromText(collectionUri, vaccineInfo.getNaziv() + ".xml", sw.toString());
    }
    
	//dodaj nove slobodne
    public void dodajNoveVakcine(String naziv, Integer kolicina) throws Exception {
    	
    	VaccineInfo vInfo = this.findByNaziv(naziv);
    	
    	existManager.update(0, collectionUri, naziv + ".xml", "//*:slobodnih", String.valueOf(vInfo.getSlobodnih() + kolicina));
    }
    
	//rezervisi jednu
    public void rezervisiJednu(String id) throws Exception {
    	VaccineInfo vInfo = this.findByNaziv(id);//
    	
    	existManager.update(0, collectionUri, id + ".xml", "//*:slobodnih", String.valueOf(vInfo.getSlobodnih()-1));
    	existManager.update(0, collectionUri, id + ".xml", "//*:rezervisanih", String.valueOf(vInfo.getRezervisanih() + 1));
    }
	
	//smanji  rezervisane za jednu
    public void obaviVakcinaciju(String naziv) throws Exception { 

    	VaccineInfo vInfo = this.findByNaziv(naziv);//
    	
    	existManager.update(0, collectionUri, naziv + ".xml", "//*rezervisanih", String.valueOf(vInfo.getRezervisanih() - 1));
    }
    
    private VaccineInfo converStringToVaccineInfo(String xml) throws JAXBException {
    	StringReader reader = new StringReader(xml);
    	
    	JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.vaccineinfo");
		Unmarshaller unmarshaller = context.createUnmarshaller();	
		//rdf??
		
		return (VaccineInfo) unmarshaller.unmarshal(reader);
    }
}
