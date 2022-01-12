package com.immunisation.officials.model.izvestaj;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateFrom",
    "dateTo"
})
@XmlRootElement(name = "Period")
public class Period {
	@XmlElement(name = "Datum_od")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateFrom;
	
	@XmlElement(name = "Datum_do")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateTo;
}
