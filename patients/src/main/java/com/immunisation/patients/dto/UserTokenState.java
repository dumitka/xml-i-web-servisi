package com.immunisation.patients.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "tokenState")
@XmlType(propOrder = {"accessToken", "expiresIn", "userRole"})
public class UserTokenState {
	
	private String accessToken;
	private Long expiresIn;
	private String userRole;
	
	public UserTokenState() {

    }

    public UserTokenState(String jwt, Long expiresIn, String role) {
        this.accessToken = jwt;
        this.expiresIn = expiresIn;
        this.userRole = role;
    }
    @XmlElement
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    @XmlElement
    public Long getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
    @XmlElement
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
