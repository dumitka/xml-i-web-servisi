package com.immunisation.officials.model;

import java.time.LocalDateTime;

import com.immunisation.officials.model.interesovanje.RequestVaccination;
import com.immunisation.officials.model.tipovi.Address;

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
public class WhenWhereVaccine {
	private RequestVaccination requestVaccination;
	private LocalDateTime date;
	private Address adress;
}
