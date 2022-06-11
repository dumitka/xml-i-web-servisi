package com.immunisation.patients;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.immunisation.patients.enums.EmploymentStatus;
import com.immunisation.patients.enums.Profession;
import com.immunisation.patients.enums.VaccineType;
import com.immunisation.patients.model.authority.Authority;
import com.immunisation.patients.model.consent.ConsentForVaccination;
import com.immunisation.patients.model.consent.PartForPatients;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.model.interest.VaccinationData;
import com.immunisation.patients.model.types.Address;
import com.immunisation.patients.model.types.Contact;
import com.immunisation.patients.model.types.ExtendUser;
import com.immunisation.patients.model.user.User;
import com.immunisation.patients.repository.AuthorityRepository;
import com.immunisation.patients.repository.ConsentForVaccinationReposity;
import com.immunisation.patients.repository.InterestRepository;
import com.immunisation.patients.repository.UserRepository;
import com.immunisation.patients.service.AuthorityService;
import com.immunisation.patients.service.CustomUserDetailsService;

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
        ConsentForVaccinationReposity cfvRepository = appContext.getBean(ConsentForVaccinationReposity.class);
        
        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin@gmail.com");
		admin.setIme("Adminko");
		admin.setPrezime("Adminic");
		admin.setJmbg("1111122222334");
		
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

        // CONSENT
        ConsentForVaccination cfv = new ConsentForVaccination();
        
        PartForPatients pfp = new PartForPatients();
        pfp.setDate(new Date(2022, 05, 05));
        
        ExtendUser patient = new ExtendUser();
        
        Address address = new Address();
        address.setNumber("22");
        address.setPlace("Novi Sad");
        address.setStreet("Zmaj Jovina");
        address.setTownship("Novi Sad");
        patient.setAddress(address);
        
        patient.setBirthdate(new Date(1979, 05, 27));
        patient.setBirthPlace("Novi Sad");
        patient.setCitizenship("Republika Srbija");
        
        Contact contact = new Contact();
        contact.setCellphone("0641234567");
        contact.setEmail("pera@gmail.com");
        contact.setLandline("021123456");
        patient.setContact(contact);
        
        patient.setDocument(pacijent.getJmbg());
        patient.setEmploymentStatus(EmploymentStatus.ZAPOSLEN);
        patient.setGender("M");
        patient.setHeadquarterOfSocialCare("");
        patient.setLastName(pacijent.getPrezime());
        patient.setName(pacijent.getIme());
        patient.setNameOfParent("Marko");
        
        patient.setProfession(Profession.PROSVETA);
        patient.setResidence("Republika Srbija");
        patient.setSocialCare(false);
        pfp.setPatient(patient);
        
        pfp.setPatientAgrees(true);
        pfp.setVaccineType(VaccineType.PFIZER);
        
        cfv.setPartForPatients(pfp);

        try {
        	cfvRepository.save(cfv);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
