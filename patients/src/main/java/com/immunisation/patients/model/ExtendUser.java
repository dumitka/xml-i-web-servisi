package com.immunisation.patients.model;


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
public class ExtendUser extends GeneralUser {
	private String nameOfParent;
	private String birthPlace;
	private Address address;
	private Contact contact;
	private String employmentStatus;
	private String profession;
	private boolean socialCare;
	private String headquarterOfSocialCare;
	
	
}
