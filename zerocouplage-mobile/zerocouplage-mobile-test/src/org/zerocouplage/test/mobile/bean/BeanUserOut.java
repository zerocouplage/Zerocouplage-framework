package org.zerocouplage.test.mobile.bean;

import java.io.File;
import java.util.Date;

public class BeanUserOut {

	private String Lastname;
	private String Firstname;
	private Date Datenaissance;
	private String Mail;
	private String Civilite;
	private Double Nbrexp;
	private String NatureDemande;
	private File Cv;

	public String getCivilite() {
		return Civilite;
	}

	public void setCivilite(String civilite) {
		Civilite = civilite;
	}

	public String getNatureDemande() {
		return NatureDemande;
	}

	public void setNatureDemande(String natureDemande) {
		NatureDemande = natureDemande;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public Date getDatenaissance() {
		return Datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		Datenaissance = datenaissance;
	}

	public Double getNbrexp() {
		return Nbrexp;
	}

	public void setNbrexp(Double nbrexp) {
		Nbrexp = nbrexp;
	}

	public File getCv() {
		return Cv;
	}

	public void setCv(File Cv) {
		this.Cv = Cv;
	}

	

}
