package com.immunisation.officials.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.userdetails.UserDetails;

import com.immunisation.officials.model.authority.Authority;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "username",
    "password",
    "jmbg",
    "ime",
    "prezime",
    "authorities"
})
@XmlRootElement(name = "user", namespace = "http://www.baklavice.com/user")
public class User implements UserDetails{
	
	@XmlElement(namespace = "http://www.baklavice.com/user", required = true)
	protected String username;
	@XmlElement(namespace = "http://www.baklavice.com/user", required = true)
	protected String password;
	@XmlElement(namespace = "http://www.baklavice.com/user")
	protected String jmbg;
	@XmlElement(namespace = "http://www.baklavice.com/user", required = true)
	protected String ime;
	@XmlElement(namespace = "http://www.baklavice.com/user", required = true)
	protected String prezime;
	@XmlElement(required = false, nillable = true)
	protected List<Authority> authorities;
	

	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public List<Authority> getAuthorities() {
		if (authorities == null) {
        	authorities = new ArrayList<Authority>();
        }
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

}
