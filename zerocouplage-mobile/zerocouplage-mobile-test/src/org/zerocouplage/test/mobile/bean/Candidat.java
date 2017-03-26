package org.zerocouplage.test.mobile.bean;

import java.io.Serializable;
import java.util.Date;


public class Candidat implements Serializable {

	private String id_candidat;
	private String nom;
	private String prenom;
	private String dan;
	private String email;
	private String civilite;
	private String nb_annee_exp;
	private String type_demande;
	private String date_demande;
	private String path;
	
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
	public String getCivilite() {
		return civilite;
	}
	public String getId_candidat() {
		return id_candidat;
	}
	public void setId_candidat(String id_candidat) {
		this.id_candidat = id_candidat;
	}
	public String getDan() {
		return dan;
	}
	public void setDan(String dan) {
		this.dan = dan;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	public String getNb_annee_exp() {
		return nb_annee_exp;
	}
	public void setNb_annee_exp(String nb_annee_exp) {
		this.nb_annee_exp = nb_annee_exp;
	}
	public String getType_demande() {
		return type_demande;
	}
	public void setType_demande(String type_demande) {
		this.type_demande = type_demande;
	}
	public String getDate_demande() {
		return date_demande;
	}
	public void setDate_demande(String date_demande) {
		this.date_demande = date_demande;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	

}
