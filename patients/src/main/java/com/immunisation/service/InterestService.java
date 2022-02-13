package com.immunisation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.patients.jaxb.JaxB;
import com.immunisation.repository.InterestRepository;


@Service
public class InterestService {
	
	@Autowired
	private JaxB jaxb;
	
	@Autowired 
	private InterestRepository repository;

	public InterestCollection getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveInterest(String interest) {
		// TODO Auto-generated method stub
		
	}

}
