package com.immunisation.patients.service;

import com.immunisation.patients.model.authority.Authority;
import com.immunisation.patients.repository.AuthorityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository repository;
	
	public Authority findByName(String name) throws Exception {
		return repository.findByName(name);
	}

}
