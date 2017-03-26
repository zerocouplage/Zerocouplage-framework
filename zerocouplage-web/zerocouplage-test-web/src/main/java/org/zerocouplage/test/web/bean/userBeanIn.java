package org.zerocouplage.test.web.bean;

import java.io.File;
import java.util.Date;

public class userBeanIn {

	private String nom;
	private String prenom;
	private Integer age;
	private Date dateanniversaire;
	private float taille;
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

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public Date getDateanniversaire() {
		return dateanniversaire;
	}

	public void setDateanniversaire(Date dateanniversaire) {
		this.dateanniversaire = dateanniversaire;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
