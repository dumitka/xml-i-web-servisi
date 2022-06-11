package com.immunisation.officials.controller;

import com.immunisation.officials.dto.VaccineDto;
import com.immunisation.officials.dto.VaccineInfoCollection;
import com.immunisation.officials.model.vaccineinfo.VaccineInfo;
import com.immunisation.officials.service.VaccineInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/vaccinfo", produces = MediaType.APPLICATION_XML_VALUE)
public class VaccineController {
	
	@Autowired
	private VaccineInfoService service;
	
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

	//dodati jos kolicinski
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
	

}
