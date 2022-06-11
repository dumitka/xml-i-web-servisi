package com.immunisation.officials.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.immunisation.officials.model.user.User;

@XmlRootElement(name = "pacijenti_collection")
public class UserCollection {

	@XmlElementWrapper(name="Pacijenti")
	@XmlElement(name="Pacijent")
	public User[] users;
	
	public UserCollection() {}
	
	public UserCollection(User[] users) {
		this.users = users;
	}
}
