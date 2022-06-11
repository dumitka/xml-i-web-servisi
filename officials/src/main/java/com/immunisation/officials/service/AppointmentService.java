package com.immunisation.officials.service;

import com.immunisation.officials.jaxb.JaxB;
import com.immunisation.officials.model.appointment.Appointment;
import com.immunisation.officials.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	private JaxB jaxb;
	
	@Autowired
	private AppointmentRepository repository;
	
	public void save(Appointment app) throws Exception {
		repository.save(app);
	}
	
	public Appointment[] searchSlobodne() throws Exception {
		System.out.println("_________++++++++++++++++++++________________EVO TRAZIMO SLOBODNE");
		return repository.searchByRezervisanFalse();
	}
	
	public void rezervisiById(String id) throws Exception {
		repository.rezervisiAppointment(id);
	}
	
	public Appointment findById(String id) throws Exception {
		return repository.findById(id);
	}
	
}
