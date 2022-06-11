package com.immunisation.officials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunisation.officials.repository.ConsentForVaccinationRepository;

@Service
public class ConsentForVaccinationService {
	@Autowired
	private ConsentForVaccinationRepository repository;
	
	public List<String> getJmbgs() throws Exception {
		return repository.getJmbgs();
	}
}
