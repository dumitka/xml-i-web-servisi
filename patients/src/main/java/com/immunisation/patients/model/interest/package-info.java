
@XmlSchema(
		namespace = "http://www.baklavice.com/interesovanje",
		elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
		xmlns = {
				@XmlNs(namespaceURI = "http://www.baklavice.com", prefix = "obv"),
				@XmlNs(namespaceURI = "http://www.ftn.uns.ac.rs/util", prefix = "util"),
				@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema#", prefix = "xs"),
				@XmlNs(namespaceURI = "http://www.baklavice.com/tipovi", prefix = "tipovi"),
				@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
				@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema", prefix="xs"),
				
		})

package com.immunisation.patients.model.interest;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;