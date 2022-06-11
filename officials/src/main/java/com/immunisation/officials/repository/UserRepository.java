package com.immunisation.officials.repository;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.immunisation.officials.model.user.User;
import com.immunisation.officials.xmldb.ExistManager;

@Repository
public class UserRepository {
	private String collectionUri = "/db/eUprava/users";

    @Autowired
    private ExistManager existManager;
	
	public User findByUsername(String username) throws Exception {
		String user = existManager.load(collectionUri, username + ".xml");

        return userFromString(user);
	}

	public User[] findAllByJMBG(List<String> jmbgs) throws Exception {
		String[] xmls = existManager.loadXmlDocsToCollection(collectionUri);
        User[] users = new User[xmls.length];

        for (int i = 0; i < xmls.length; i++) {
        	User user = userFromString(xmls[i]);
        	if (jmbgs.contains(user.getJmbg())) {
                users[i] = userFromString(xmls[i]);
			}
        }

        return users;
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
	
	private User userFromString(String xml) throws JAXBException {
		StringReader stringReader = new StringReader(xml);

		JAXBContext context = JAXBContext.newInstance("com.immunisation.officials.model.user");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		return (User) unmarshaller.unmarshal(stringReader);
	}
}
