package com.immunisation.officials.model;

import java.time.LocalTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.immunisation.officials.util.LocalTimeTypeConverter;

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
