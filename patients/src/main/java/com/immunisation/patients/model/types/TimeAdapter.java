package com.immunisation.patients.model.types;

import java.time.LocalTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.immunisation.patients.util.LocalTimeTypeConverter;


public class TimeAdapter extends XmlAdapter<String, LocalTime>{

	@Override
	public LocalTime unmarshal(String v) throws Exception {
		return (LocalTimeTypeConverter.parseTime(v));
	}

	@Override
	public String marshal(LocalTime v) throws Exception {
		return (LocalTimeTypeConverter.printTime(v));
	}

}
