package com.immunisation.officials.service;


import java.util.ArrayList;
import java.util.List;

import com.immunisation.officials.dto.RegistrationRequest;
import com.immunisation.officials.dto.UserTokenState;
import com.immunisation.officials.model.authority.Authority;
import com.immunisation.officials.model.user.User;
import com.immunisation.officials.repository.UserRepository;
import com.immunisation.officials.security.TokenUtils;
import com.immunisation.officials.util.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private Mapper mapper;
	
// NE KORISTIMO NIGDE
	
//	public void createNewUser(RegistrationRequest data) throws Exception {
//		User user = mapper.convertToEntity(data);
//		
//		user.setPassword(userDetailsService.encodePassword(user.getPassword()));
//		
//		List<Authority> authorities = new ArrayList<>();
//		Authority a = authorityService.findByName("ROLE_USER");
//		authorities.add(a);
//		user.setAuthorities(authorities);
//		
//		repository.save(user);
//	}

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
