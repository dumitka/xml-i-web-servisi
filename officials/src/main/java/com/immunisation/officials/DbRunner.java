package com.immunisation.officials;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.immunisation.officials.model.appointment.Appointment;
import com.immunisation.officials.model.authority.Authority;
import com.immunisation.officials.model.user.User;
import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.repository.AuthorityRepository;
import com.immunisation.officials.repository.UserRepository;
import com.immunisation.officials.service.AppointmentService;
import com.immunisation.officials.service.AuthorityService;
import com.immunisation.officials.service.CustomUserDetailsService;
import com.immunisation.officials.service.VaccineInfoService;

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
        sluzbenik.setJmbg(1199122662333L);
		
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
        zRadnik.setJmbg(1117722222333L);
		
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
        
        
        //VACCINES
        
        VaccineInfoService vaccService = appContext.getBean(VaccineInfoService.class);
        
        VaccineInfo vacc1 = new VaccineInfo();
        vacc1.setNaziv("Pfizer-BioNTech");
        vacc1.setSlobodnih(5);
        vacc1.setRezervisanih(0);
        
        
        VaccineInfo vacc2 = new VaccineInfo();
        vacc2.setNaziv("Sputnik-V");
        vacc2.setSlobodnih(6);
        vacc2.setRezervisanih(0);
        
        VaccineInfo vacc3 = new VaccineInfo();
        vacc3.setNaziv("Sinopharm");
        vacc3.setSlobodnih(7);
        vacc3.setRezervisanih(0);
        
        VaccineInfo vacc4 = new VaccineInfo();
        vacc4.setNaziv("AstraZeneca");
        vacc4.setSlobodnih(8);
        vacc4.setRezervisanih(0);
        
        VaccineInfo vacc5 = new VaccineInfo();
        vacc5.setNaziv("Moderna");
        vacc5.setSlobodnih(9);
        vacc5.setRezervisanih(0);
        
        try {
        	vaccService.save(vacc1);
        	vaccService.save(vacc2);
        	vaccService.save(vacc3);
        	vaccService.save(vacc4);
        	vaccService.save(vacc5);
        	System.out.println("Dodali smo vakcine");
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
        
        
        //APPOINTMENTS
        
        AppointmentService appService = appContext.getBean(AppointmentService.class);
        
        int dateRange = 10;
        LocalDate sad = LocalDate.now();
        List<Date> dates = new ArrayList<>();
        List<LocalTime> times = new ArrayList<>();
        
        for(int i = 0; i < dateRange; i++) {
        	LocalDate localDate = sad.plusDays(i);
        	Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        	dates.add(date);
        }

        for(int i = 8; i <= 16; i++) {
        	LocalTime time = LocalTime.of(i, 0);
        	times.add(time);
        }
        //Za svaki dan, za svako vreme novi termin
        for(Date date: dates) {
        	for(LocalTime time : times) {
        		Appointment a = new Appointment();
        		a.setDatum(date);
        		a.setVremeSeconds(time.get(ChronoField.SECOND_OF_DAY));
        		a.setId(UUID.randomUUID().toString());
        		a.setRezervisan(false);
        		
        		try {
					appService.save(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        }
        
        System.out.println("Ubacili smo termine");
//  
        
	}
	
}
