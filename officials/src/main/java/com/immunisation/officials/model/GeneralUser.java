package com.immunisation.officials.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUser {
	private String citizenship;
	private String residence;
	private String name;
	private String lastName;
	private String gender;
	private LocalDateTime birthdate;
	private String UPIN; //Unique Personal Identification Number il' ti JMBG
	private String passportNumber;
}
