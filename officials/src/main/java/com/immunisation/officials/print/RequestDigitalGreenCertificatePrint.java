package com.immunisation.officials.print;


import com.immunisation.officials.model.zahtev_za_sertifikat.RequestDigitalGreenCertificate;

public class RequestDigitalGreenCertificatePrint {
	public static void print(RequestDigitalGreenCertificate request) {
		System.out.println("ZAHTEV ZA DIGITALNI ZELIENI SERTIFIKAT");
		System.out.println("Sifra_zahteva --> " + request.getCode());
		System.out.println("Ime_dokumenta --> " + request.getName());
		System.out.print("Podaci_o_podnosiocu --> ");
		//GeneralUserPrint.print(request.getUser());
		System.out.println("Razlog_podnosenja_zahteva --> " + request.getReasonForRequest());
		System.out.println("Mesto_podnosenja_zahteva --> " + request.getPlace());
		System.out.println("Datum_podnosenja_zahteva --> " + request.getDate());
	}
	
}
