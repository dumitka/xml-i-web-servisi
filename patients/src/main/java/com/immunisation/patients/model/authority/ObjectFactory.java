package com.immunisation.patients.model.authority;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	
	public ObjectFactory() {
    }

    public Authority createAuthority() {
        return new Authority();
    }
}
