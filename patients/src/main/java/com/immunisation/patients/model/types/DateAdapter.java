package com.immunisation.patients.model.types;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.immunisation.patients.util.DateTypeConverter;


public class DateAdapter extends XmlAdapter<String, Date>{
	 public Date unmarshal(String value) {
	        return (DateTypeConverter.parseDate(value));
	    }

	    public String marshal(Date value) {
	        return (DateTypeConverter.printDate(value));
	    }
}
