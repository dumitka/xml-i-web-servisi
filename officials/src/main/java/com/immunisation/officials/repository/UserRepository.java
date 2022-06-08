package com.immunisation.officials.repository;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.immunisation.officials.model.user.User;
import com.immunisation.officials.xmldb.ExistManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private String collectionUri = "/db/eUprava/users";

    @Autowired
    private ExistManager existManager;
	
	
	public User findByUsername(String username) throws Exception {
		String user = existManager.load(collectionUri, username + ".xml");

        JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.user");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader sr = new StringReader(user);

        User userInstance = (User) unmarshaller.unmarshal(sr);
        return userInstance;
	}

	public void save(User user) throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.user");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        marshaller.marshal(user, sw);

        existManager.storeFromText(collectionUri, user.getUsername() + ".xml", sw.toString());
    }
	
	public void save(String user, String username) throws Exception {
        existManager.storeFromText(collectionUri, username + ".xml", user);
    }
}
