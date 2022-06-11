package com.immunisation.officials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.immunisation.officials.dto.UserCollection;
import com.immunisation.officials.dto.UserTokenState;
import com.immunisation.officials.model.user.User;
import com.immunisation.officials.repository.UserRepository;
import com.immunisation.officials.security.TokenUtils;

@Service
public class UserService {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	public User findByUsername(String username) throws Exception {
		return repository.findByUsername(username);
	}
	
	public UserCollection getPatientsWithConsent(List<String> jmbgs) throws Exception {
		User[] users = repository.findAllByJMBG(jmbgs);
		return new UserCollection(users);
	}
	
	public UserTokenState tryLogin(String username, String password) throws Exception {
		User existing = repository.findByUsername(username);
		
		Authentication authentication = null;
		authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername(), user);
        long expiresIn = tokenUtils.getExpiredIn();
        
        String role = user.getAuthorities().get(0).getName();
        
		return  new UserTokenState(jwt, expiresIn, role);
	}
}
