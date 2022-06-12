package com.immunisation.officials.model.consent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"code",
    "partForPatients",
    "partForPublicOfficial"
})
@XmlRootElement(name = "Saglasnost")
public class ConsentForVaccination {
	@XmlElement(name = "Sifra_saglasnosti")
	private String code;
	
	@XmlElement(name = "Deo_za_pacijenta")
	private PartForPatients partForPatients;
	
	@XmlElement(name = "Deo_za_radnika")
	private PartForPublicOfficial partForPublicOfficial;
	
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

	public PartForPatients getPartForPatients() {
		return partForPatients;
	}

	public void setPartForPatients(PartForPatients partForPatients) {
		this.partForPatients = partForPatients;
	}

	public PartForPublicOfficial getPartForPublicOfficial() {
		return partForPublicOfficial;
	}

	public void setPartForPublicOfficial(PartForPublicOfficial partForPublicOfficial) {
		this.partForPublicOfficial = partForPublicOfficial;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
