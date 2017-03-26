package org.zerocouplage.test.mobile.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBeanIn  {

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int age;
	private Float taille;
	private Boolean question;
	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Boolean getQuestion() {
		return question;
	}
	public void setQuestion(Boolean question) {
		this.question = question;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Float getTaille() {
		return taille;
	}
	public void setTaille(Float taille) {
		this.taille = taille;
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
