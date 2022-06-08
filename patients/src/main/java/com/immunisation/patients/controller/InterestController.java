package com.immunisation.patients.controller;

import com.immunisation.patients.dto.InterestCollection;
import com.immunisation.patients.service.InterestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/interest", produces = MediaType.APPLICATION_XML_VALUE)
public class InterestController {
	
	
	@Autowired
	private InterestService service;
	
	@GetMapping(value = "/hello", produces = MediaType.ALL_VALUE)
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
//	@GetMapping(value = "/helloxml", produces = MediaType.APPLICATION_XML_VALUE)   NE RADI
//	public ResponseEntity<Object> helloxml() throws ParserConfigurationException, SAXException, IOException {
//		String xml = "<hello>HELLO MY FRIEND</hello>";
//		
//		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
//	            "<Tutorial id=\"1\"><technology>Dot net, Java, Big data, Database</technology>\n"+
//	            "<address>topjavatutorial.com</address></Tutorial>";
//		
//		
//		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//	    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//	    Document document = (Document) docBuilder.parse(new InputSource(new StringReader(xmlStr)));
//	
//		
//		return new ResponseEntity<>(document, HttpStatus.OK);
//	}
	
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
	public ResponseEntity<Object> saveInterest(@RequestBody String interest) {
		try {
			service.saveInterest(interest);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error while saving Interest", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
