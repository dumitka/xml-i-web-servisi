package com.immunisation.officials;

import java.util.ArrayList;

import com.immunisation.officials.model.authority.Authority;
import com.immunisation.officials.model.user.User;
import com.immunisation.officials.repository.AuthorityRepository;
import com.immunisation.officials.repository.UserRepository;
import com.immunisation.officials.service.AuthorityService;
import com.immunisation.officials.service.CustomUserDetailsService;

import org.springframework.context.ApplicationContext;

public class DbRunner {
	private static String[] roles = {"ROLE_Z_RADNIK", "ROLE_SLUZBENIK"};
	
	public static void execute(ApplicationContext appContext) {
		///// ROLES
		
		AuthorityRepository authRepo = appContext.getBean(AuthorityRepository.class);
		
//		long counter = ThreadLocalRandom.current().nextInt(3, 10 + 1);;
		long counter = 0;
		
		for (String role : roles) {
            try {
            	authRepo.findByName(role);
            } catch (NullPointerException e) {
                try {
                	authRepo.save(role, counter);
                	counter++;
                	System.out.println("Imamo rolu:  " + role);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		 //USERS
		
		CustomUserDetailsService userDetailsService = appContext.getBean(CustomUserDetailsService.class);
        UserRepository userRepo = appContext.getBean(UserRepository.class);
        AuthorityService authorityService = appContext.getBean(AuthorityService.class);
        
        User sluzbenik = new User();
        sluzbenik.setPassword("sluzbenik");
        sluzbenik.setUsername("sluzbenik@gmail.com");
        sluzbenik.setIme("Sluzbenik");
        sluzbenik.setPrezime("Sluzic");
        sluzbenik.setJmbg("1199122662333");
		
        sluzbenik.setPassword(userDetailsService.encodePassword(sluzbenik.getPassword()));
		
		ArrayList<Authority> auth = new ArrayList<>();

        try {
            auth.add(authorityService.findByName("ROLE_SLUZBENIK"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sluzbenik.setAuthorities(auth);

        try {
            userRepo.save(sluzbenik);
            System.out.println("Imamo sluzbenika:  " + sluzbenik.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        User zRadnik = new User();
        zRadnik.setPassword("zradnik");
        zRadnik.setUsername("zradnik@gmail.com");
        zRadnik.setIme("Zdravstven");
        zRadnik.setPrezime("Radnicic");
        zRadnik.setJmbg("1117722222333");
		
        zRadnik.setPassword(userDetailsService.encodePassword(zRadnik.getPassword()));
		
		auth = new ArrayList<>();

        try {
            auth.add(authorityService.findByName("ROLE_Z_RADNIK"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        zRadnik.setAuthorities(auth);

        try {
            userRepo.save(zRadnik);
            System.out.println("Imamo zdravstvenog radnika:  " + zRadnik.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
}
