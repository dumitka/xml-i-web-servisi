package com.immunisation.patients.controller;

import java.util.HashMap;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.patients.dto.MailPackage;
import com.immunisation.patients.dto.VaccinationDate;
import com.immunisation.patients.enums.VaccineType;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.service.EmailService;
import com.immunisation.patients.service.InterestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "api/interest", produces = MediaType.APPLICATION_XML_VALUE)
public class InterestController {
	
	
	@Autowired
	private InterestService service;
	
	@Autowired 
	private EmailService emailService;
	
	@GetMapping(value = "/hello", produces = MediaType.ALL_VALUE)
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE) //produces?
	public ResponseEntity<Object> getAll() {
		try {
			InterestCollection collection = service.getAll();
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while getting Interests", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> save(@RequestBody String interest) throws Exception {
		Interest interestObj = null;
		try {
			interestObj = service.saveInterestFromString(interest);
			System.out.println(interestObj.getVaccinationData().getVaccineType());
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		MailPackage mp = emailService.confirmInterestCreation(interestObj);
		
		HashMap<String, Long> params = new HashMap<>();
		try {
		     ResponseEntity<Object> response = new RestTemplate().postForEntity("http://localhost:8084/api/mail", mp, Object.class, params);
		}
		catch (Exception ex) {
		    throw new Exception("Mail Not working");
		}

//		Sputnik-V
		
		ResponseEntity<VaccinationDate> vaccinationDate = null;
		System.out.println("____________________________________EVO SAD SMO POSLALI MEJL VERIFIKACIJE< IDEMO DA TRAZIMO TERMIN");
		//potrazi termin
		try {
			String uri = "http://localhost:8081/api/vaccinfo/zakazivanje/" + getVaccineName(interestObj);
			System.out.println("____________________________________EVO URI" + uri);
			
			//////
//			RestTemplate restTemplate = new RestTemplate();
//			HttpHeaders headers = new HttpHeaders();
////			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML_VALUE));
//			headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
//			
//			HttpEntity<VaccinationDate> entity = new HttpEntity<VaccinationDate>(headers);
			
			///////
//			new RestTemplate().exchange(uri, HttpMethod.GET, )
			vaccinationDate = new RestTemplate().getForEntity(uri,VaccinationDate.class, params);
			System.out.println("___________________________________ZAVRSEN REQ ZA OFFICIALS");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		    throw new Exception("Could not contact officials");
		}
		
		//ako ga nadjes, salji mejl, ako ne, nista
		if(vaccinationDate.getBody() != null) {
			System.out.println("_______________________________________________" + vaccinationDate.getBody());
			MailPackage mp2 = emailService.sendVaccinationDate(vaccinationDate.getBody(), interestObj.getContact().getEmail(), interestObj.getVaccinationData().getTownshipOfInstitution());
			try {
				System.out.println("SAD SMO ZNACI DOBILI TERMIN PA KREIRALI MEJL, EVO POZIV KA MEJL SERVISU");
			     ResponseEntity<Object> mailResponse = new RestTemplate().postForEntity("http://localhost:8084/api/mail", mp2, Object.class, params);
			     System.out.println("___________________________GOTOV POZIV KA MEJL SERVISU");
			}
			catch (Exception ex) {
			    throw new Exception("Mail Not working");
			}
		}
		System.out.println("_____________________________IZGLEDA NISMO NASLI TERMIN??");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private String getVaccineName(Interest interestObj) {
		VaccineType vacc = interestObj.getVaccinationData().getVaccineType();
		
		switch(vacc) {
			case PFIZER:
				return "Pfizer-BioNTech";
			case SPUTNIK:
				return "Sputnik-V";
			case ASTRA_ZENECA:
				return "AstraZeneca";
			case MODERNA:
				return "Moderna";
			case SINOPHARM:
				return "Sinopharm";
		}
		
		return "";
	}
	
}
