
@XmlSchema( 
		   namespace = "http://www.baklavice.com/saglasnost",
		   elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
		   xmlns = {
        			@javax.xml.bind.annotation.XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema"),
        			@javax.xml.bind.annotation.XmlNs(prefix="tipovi", namespaceURI="http://www.baklavice.com/tipovi")
        	})

package com.immunisation.officials.model.consent;

import javax.xml.bind.annotation.XmlSchema;