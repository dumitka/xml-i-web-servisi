package com.immunisation.patients.service;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import com.immunisation.patients.dto.MailPackage;
import com.immunisation.patients.dto.VaccinationDate;
import com.immunisation.patients.model.interest.Interest;
import com.immunisation.patients.util.DateTypeConverter;
import com.immunisation.patients.util.LocalTimeTypeConverter;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public MailPackage confirmInterestCreation(Interest i) {
		
		String text = "Poštovani,\n"
				+ "Portal za pacijente je primio vaš zahtev za vakcinaciju. Dobićete obaveštenje o prvom slobodnom terminu imunizacije uskoro.\n"
				+ "Ovo su vaši podaci sa dokumenta: \n"
				
				+ "Državljanstvo: " +  i.getPatient().getCitizenship() + "\n"
				+ "Boravište: " + i.getPatient().getResidence() + "\n"
				+ "Ime: " + i.getPatient().getName() + "\n"
				+ "Prezime: " + i.getPatient().getLastName() + "\n"
				+ "Pol: " + i.getPatient().getGender() + "\n"
				+ "Datum rođenja: " + i.getPatient().getBirthdate() + "\n"
				+ "Lični dokument(JMBG): " + i.getPatient().getJmbg() + "\n"
				+ "Email adresa: " + i.getContact().getEmail() + "\n"
				+ "Broj mobilnog telefona: " + i.getContact().getCellphone() + "\n"
				+ "Broj fiksnog telefona: " + i.getContact().getLandline() + "\n"
				+ "Opština ustanove: " + i.getVaccinationData().getTownshipOfInstitution()  + "\n"
				+ "Tip vakcine: " + i.getVaccinationData().getVaccineType() + "\n"
				+ "Davalac krvi: " + (i.getVaccinationData().isBloodDonor() == true ? "Da" : "Ne") + "\n"
				+ "Datum interesovanja: " + i.getDate()  + "\n";
		
		MailPackage mp = new MailPackage();
		mp.setRecipient(i.getContact().getEmail());
		mp.setSubject("Potvrda zahteva za imunizaciju");
		mp.setBody(text);
		
		
		return mp;
	}

	public MailPackage sendVaccinationDate(VaccinationDate vd, String email, String mesto) {
		int totalSecs = vd.vremeSeconds;
		int hours = totalSecs / 3600;
		int minutes = (totalSecs % 3600) / 60;

		String timeString = String.format("%02d:%02d", hours, minutes);
		
		String text = "Poštovani,\n"
				+ "Portal za imunizaciju je pronašao slobodan termin i rezervisao dozu "+ vd.naziv + " vakcine za Vas.\n"   // . Dobićete obaveštenje o prvom slobodnom terminu imunizacije uskoro.\n"
				+ "Ovo je vreme i mesto vaše prve imunizacije: \n\n" 
				+ "Mesto: " + mesto + "\n"
				+ "Datum: " + DateTypeConverter.printDate(vd.datum) + "\n"
				+ "Vreme: " + timeString;
		
		
		MailPackage mp = new MailPackage();
		mp.setRecipient(email);
		mp.setSubject("Termin prve vakcinacije");
		mp.setBody(text);
		return mp;
	}

}
