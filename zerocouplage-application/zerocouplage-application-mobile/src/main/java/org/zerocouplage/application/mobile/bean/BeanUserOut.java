package org.zerocouplage.application.mobile.bean;

import java.io.Serializable;


public class BeanUserOut implements Serializable{

	private String lastName;
	private String firstName;
	private String civilite;
	private String pathCv;

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPathCv() {
		return pathCv;
	}

	public void setPathCv(String pathCv) {
		this.pathCv = pathCv;
	}
}
