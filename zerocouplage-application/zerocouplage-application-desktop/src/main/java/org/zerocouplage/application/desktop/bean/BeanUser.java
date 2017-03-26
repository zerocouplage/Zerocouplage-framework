package org.zerocouplage.application.desktop.bean;

import java.io.File;
import java.util.Date;

public class BeanUser {
	
	private int idUser;
	private String nom;
	private String prenom;
	private Date dan;
	private String email;
	private String civilite;
	private Double nbAnneeExp;
	private String natureDemande;
	private File Cv;
	private String path;
	private Date dateDemande;
	
	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNatureDemande() {
		return natureDemande;
	}

	public void setNatureDemande(String natureDemande) {
		this.natureDemande = natureDemande;
	}

	public File getCv() {
		return Cv;
	}

	public void setCv(File Cv) {
		this.Cv = Cv;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDan() {
		return dan;
	}

	public void setDan(Date dan) {
		this.dan = dan;
	}

	public Double getNbAnneeExp() {
		return nbAnneeExp;
	}

	public void setNbAnneeExp(Double nbAnneeExp) {
		this.nbAnneeExp = nbAnneeExp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
