package com.immunisation.officials.controller;

import com.immunisation.officials.dto.VaccinationDate;
import com.immunisation.officials.dto.VaccineDto;
import com.immunisation.officials.dto.VaccineInfoCollection;
import com.immunisation.officials.model.appointment.Appointment;
import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.service.AppointmentService;
import com.immunisation.officials.service.VaccineInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/vaccinfo", produces = MediaType.APPLICATION_XML_VALUE)
public class VaccineController {
	
	@Autowired
	private VaccineInfoService service;
	
	@Autowired
	private AppointmentService appService;
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getAll() {
		try {
			VaccineInfoCollection collection = service.getAll();
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while getting vaccineInfos", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> dodajNove(@RequestBody VaccineDto dto) {
		try {
			service.dodajNoveVakcine(dto.getName(), dto.getKolicina());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while adding new vacc", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{naziv}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<VaccineInfo> getByNaziv(@PathVariable String naziv) {
		try {
			VaccineInfo v = service.getByNaziv(naziv);
			return new ResponseEntity<>(v, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/zakazivanje/{vakcina}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<VaccinationDate> zakazivanje(@PathVariable String vakcina) throws Exception {
		System.out.println("______________________________________STIGAO ZAHTEV ZA ZAKAZIVANJE, VAKCINA SLEDECA: " + vakcina);
		try {
			System.out.println(vakcina);
			VaccineInfo vaccInfo = service.getByNaziv(vakcina);
			Appointment[] array = appService.searchSlobodne();
			
			if(vaccInfo.getSlobodnih() < 1 || array.length == 0) {
				System.out.println("_______________________________________ILI NEMA VAKCINE< ILI NEMA TERMINA, EVO OBJEKATA");
				System.out.println(vaccInfo);
				System.out.println(array);
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
			System.out.println("____________________________________NASLI SMO I VAKCINU I TERMIN");
			Appointment a = array[0];
			service.rezervisiJednuDozu(vakcina);
			appService.rezervisiById(a.getId());
			System.out.println(a.getDatum());
			System.out.println(a.getVremeSeconds());
			VaccinationDate dto = new VaccinationDate(vakcina, a.getDatum(), a.getVremeSeconds());
			
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
