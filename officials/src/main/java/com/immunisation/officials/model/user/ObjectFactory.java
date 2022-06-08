package com.immunisation.officials.model.user;

import javax.xml.bind.annotation.XmlRegistry;

import com.immunisation.officials.model.authority.Authority;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}
	
	public User createUser() {
		return new User();
	}
	
	public Authority createAuthority() {
		return new Authority();
	}
	
}
