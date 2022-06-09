package com.immunisation.officials.model.report;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.officials.model.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"code",
	"period",
    "numberOfInterests",
    "requestDigitalGreenCertificate",
    "digitalGreenCertificate",
    "vaccineDosesForReport",
    "distributionOfManufacturers",
    "dateOfIssue"
})
@XmlRootElement(name = "Izvestaj")
public class Report {
	@XmlElement(name = "Sifra_izvestaja", required = true)
	private String code;
	
	@XmlElement(name = "Period")
	private Period period;
	
	@XmlElement(name = "Broj_interesovanja")
	private int numberOfInterests;
	
	@XmlElement(name = "Zahtevi_za_sertifikat")
	private int requestDigitalGreenCertificate;
	
	@XmlElement(name = "Izdati_sertifikati")
	private int digitalGreenCertificate;
	
	@XmlElement(name = "Doze_vakcine")
	private VaccineDosesForReport vaccineDosesForReport;
	
	@XmlElementWrapper(name="Raspodela_proizvodjaca")
	@XmlElement(name="Proizvodjac")
	private List<Manufacturer> distributionOfManufacturers;
	
	@XmlElement(name = "Datum_izdavanja")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfIssue;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public int getNumberOfInterests() {
		return numberOfInterests;
	}

	public void setNumberOfInterests(int numberOfInterests) {
		this.numberOfInterests = numberOfInterests;
	}

	public int getRequestDigitalGreenCertificate() {
		return requestDigitalGreenCertificate;
	}

	public void setRequestDigitalGreenCertificate(int requestDigitalGreenCertificate) {
		this.requestDigitalGreenCertificate = requestDigitalGreenCertificate;
	}

	public int getDigitalGreenCertificate() {
		return digitalGreenCertificate;
	}

	public void setDigitalGreenCertificate(int digitalGreenCertificate) {
		this.digitalGreenCertificate = digitalGreenCertificate;
	}

	public VaccineDosesForReport getVaccineDosesForReport() {
		return vaccineDosesForReport;
	}

	public void setVaccineDosesForReport(VaccineDosesForReport vaccineDosesForReport) {
		this.vaccineDosesForReport = vaccineDosesForReport;
	}

	public List<Manufacturer> getDistributionOfManufacturers() {
		return distributionOfManufacturers;
	}

	public void setDistributionOfManufacturers(List<Manufacturer> distributionOfManufacturers) {
		this.distributionOfManufacturers = distributionOfManufacturers;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	
}
