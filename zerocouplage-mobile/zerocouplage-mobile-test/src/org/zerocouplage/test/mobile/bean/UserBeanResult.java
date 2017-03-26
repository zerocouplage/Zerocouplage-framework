package org.zerocouplage.test.mobile.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBeanResult implements Serializable {

	private String firstname;
	private String lastname;
	private Date birthday;
	private Double nbAnneeExp;
	private String mySpinner;
	private File cv;

	public File getCv() {
		return cv;
	}
	public void setCv(File cv) {
		cv = cv;
	}
	public String getMySpinner() {
		return mySpinner;
	}
	public void setMySpinner(String mySpinner) {
		mySpinner = mySpinner;
	}
	public Double getNbAnneeExp() {
		return nbAnneeExp;
	}
	public void setNbAnneeExp(Double nbAnneeExp) {
		this.nbAnneeExp = nbAnneeExp;
	}
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String civilite;
public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	//	private File file;
//	public File getFile() {
//		return file;
//	}
//	public void setFile(File file) {
//		this.file = file;
//	}
	public Date getDate_naissance() {
		return birthday;
	}
	public void setDate_naissance(Date birthday) {
		this.birthday = birthday;
	}

	

	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
		
}
