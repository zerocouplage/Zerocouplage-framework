package org.zerocouplage.test.mobile.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBeanIn implements Serializable {

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Double nbAnneeExp;

	private String email;
	
	private String civilite;
	
	private String natureDemande;
	
	private File cv;
	
public File getCv() {
		return cv;
	}
	public void setCv(File cv) {
		this.cv = cv;
	}
public String getNatureDemande() {
		return natureDemande;
	}
	public void setNatureDemande(String natureDemande) {
		this.natureDemande = natureDemande;
	}
	//	private File file;
//	public File getFile() {
//		return file;
//	}
//	public void setFile(File file) {
//		this.file = file;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public Double getNbAnneeExp() {
		return nbAnneeExp;
	}
	public void setNbAnneeExp(Double nbAnneeExp) {
		this.nbAnneeExp = nbAnneeExp;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
