package com.immunisation.officials.model;

import java.time.LocalDateTime;

import com.immunisation.officials.model.interest.Interest;
import com.immunisation.officials.model.types.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class WhenWhereVaccine {
//	private Interest requestVaccination;
	private LocalDateTime date;
	private Address adress;
}
