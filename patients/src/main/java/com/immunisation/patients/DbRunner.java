package com.immunisation.patients;

import java.util.ArrayList;
import java.util.Date;

import com.immunisation.patients.enums.VaccineType;
import com.immunisation.patients.model.authority.Authority;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.model.interest.VaccinationData;
import com.immunisation.patients.model.types.Address;
import com.immunisation.patients.model.types.Contact;
import com.immunisation.patients.model.types.ExtendUser;
import com.immunisation.patients.model.user.User;
import com.immunisation.patients.repository.AuthorityRepository;
import com.immunisation.patients.repository.InterestRepository;
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
        InterestRepository inRepo = appContext.getBean(InterestRepository.class);
        AuthorityService authorityService = appContext.getBean(AuthorityService.class);
        
        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin@gmail.com");
		admin.setIme("Adminko");
		admin.setPrezime("Adminic");
		admin.setJmbg(1111122222333L);
		
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
        pacijent.setJmbg(1111122222333L);
		
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
        
        
        //INTEREST
        Interest in = new Interest();
        in.setCode("123");
        
        Contact c = new Contact();
        c.setCellphone("054666777");
        c.setEmail("abc@sdfl.com");
        c.setLandline("021 777 888");
        
        in.setContact(c);
        in.setDate(new Date());
        
        ExtendUser pacc = new ExtendUser();
        
        Address a = new Address();
        a.setNumber("3");
        a.setPlace("Bg");
        a.setStreet("Ulica");
        a.setTownship("Towwwnship");
        
        pacc.setAddress(a);
        pacc.setGender("ZENSKI");
        pacc.setJmbg("123456543211");
        pacc.setName("PROBA IZ DB RANERA");
        pacc.setLastName("HEHEHHE");
        in.setPatient(pacc);
        
        VaccinationData vd = new VaccinationData();
        vd.setBloodDonor(false);
        vd.setTownshipOfInstitution("247365021");
        vd.setVaccineType(VaccineType.PFIZER);
        in.setVaccinationData(vd);
        try {
        	inRepo.save(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
	}
	
	
}
