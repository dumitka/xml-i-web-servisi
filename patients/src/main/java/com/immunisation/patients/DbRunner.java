package com.immunisation.patients;

import java.util.ArrayList;

import com.immunisation.patients.model.authority.Authority;
import com.immunisation.patients.model.user.User;
import com.immunisation.patients.repository.AuthorityRepository;
import com.immunisation.patients.repository.UserRepository;
import com.immunisation.patients.service.AuthorityService;
import com.immunisation.patients.service.CustomUserDetailsService;

import org.springframework.context.ApplicationContext;

public class DbRunner {

	private static String[] roles = {"ROLE_USER", "ROLE_ADMIN"};
	
	public static void execute(ApplicationContext appContext) {
		///// ROLES
		
		AuthorityRepository authRepo = appContext.getBean(AuthorityRepository.class);
		
		long counter = 0;
		
		for (String role : roles) {
            try {
            	authRepo.findByName(role);
            } catch (NullPointerException e) {
                try {
                	authRepo.save(role, counter);
                	counter++;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		///// USERS
		
		CustomUserDetailsService userDetailsService = appContext.getBean(CustomUserDetailsService.class);
        UserRepository userRepo = appContext.getBean(UserRepository.class);
        AuthorityService authorityService = appContext.getBean(AuthorityService.class);
        
        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin@gmail.com");
		admin.setIme("Adminko");
		admin.setPrezime("Adminic");
		admin.setJmbg("1111122222333");
		
		admin.setPassword(userDetailsService.encodePassword(admin.getPassword()));
		
		ArrayList<Authority> auth = new ArrayList<>();

        try {
            auth.add(authorityService.findByName("ROLE_ADMIN"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        admin.setAuthorities(auth);

        try {
            userRepo.save(admin);
            System.out.println("Imamo admina:  " + admin.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        User pacijent = new User();
        pacijent.setPassword("pera");
        pacijent.setUsername("pera@gmail.com");
        pacijent.setIme("Petar");
        pacijent.setPrezime("Peric");
        pacijent.setJmbg("1111122222333");
		
        pacijent.setPassword(userDetailsService.encodePassword(pacijent.getPassword()));
		
		auth = new ArrayList<>();

        try {
            auth.add(authorityService.findByName("ROLE_USER"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pacijent.setAuthorities(auth);

        try {
            userRepo.save(pacijent);
            System.out.println("Imamo pacijenta:  " + pacijent.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	
}
