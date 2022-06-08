package com.immunisation.officials.service;


import com.immunisation.officials.model.user.User;
import com.immunisation.officials.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user;
		try {
			user = userRepository.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException(String.format("No user found with given username '%s' :(", username));
			} else {
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}

	public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
