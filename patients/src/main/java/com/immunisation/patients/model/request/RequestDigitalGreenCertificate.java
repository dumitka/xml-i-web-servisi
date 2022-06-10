package com.immunisation.patients.model.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.immunisation.patients.model.types.DateAdapter;
import com.immunisation.patients.model.types.GeneralUser;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"code",
    "statement",
    "user",
    "reasonForRequest",
    "place",
    "date"
})
@XmlRootElement(name = "Zahtev")
public class RequestDigitalGreenCertificate {
	@XmlElement(name = "Sifra_zahteva")
	private String code;
	
	@XmlAttribute(name = "Ime_dokumenta")
	private String name;
	
	@XmlElement(name = "Izjava_podnosenja_zahteva")
	private String statement;
	
	@XmlElement(name = "Podaci_o_podnosiocu")
	private GeneralUser user;
	
	@XmlElement(name = "Razlog_podnosenja_zahteva")
	private String reasonForRequest;
	
	@XmlElement(name = "Mesto_podnosenja_zahteva")
	private String place; //mjesto podnosenja zahtjeva
	
	@XmlElement(name = "Datum_podnosenja_zahteva")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date; //datum podnosenja zahtjeva
	
	
	@XmlAttribute(name = "vocab")
    @XmlSchemaType(name = "anySimpleType")
    protected String vocab;
    @XmlAttribute(name = "about")
    @XmlSchemaType(name = "anySimpleType")
    protected String about;
    @XmlAttribute(name = "rel")
    @XmlSchemaType(name = "anySimpleType")
    protected String rel;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anySimpleType")
    protected String href;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    
    
	public String getVocab() {
		return vocab;
	}

	public void setVocab(String vocab) {
		this.vocab = vocab;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public GeneralUser getUser() {
		return user;
	}

	public void setUser(GeneralUser user) {
		this.user = user;
	}

	public String getReasonForRequest() {
		return reasonForRequest;
	}

	public void setReasonForRequest(String reasonForRequest) {
		this.reasonForRequest = reasonForRequest;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
