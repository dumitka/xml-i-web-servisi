package com.immunisation.patients.util;

import com.immunisation.patients.dto.RegistrationRequest;
import com.immunisation.patients.model.user.User;

import org.springframework.stereotype.Service;

@Service
public class Mapper {

	public User convertToEntity(RegistrationRequest data) {
		
		User user = new User();
		user.setUsername(data.getUsername());
		user.setPassword(data.getPassword());
		user.setIme(data.getIme());
		user.setPrezime(data.getPrezime());
		user.setJmbg(data.getJmbg());
		
		return user;
	}

}
