package com.immunisation.officials.service;



import com.immunisation.officials.model.authority.Authority;
import com.immunisation.officials.repository.AuthorityRepository;

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
