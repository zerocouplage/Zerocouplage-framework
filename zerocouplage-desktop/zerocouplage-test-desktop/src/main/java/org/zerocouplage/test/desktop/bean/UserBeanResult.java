package org.zerocouplage.test.desktop.bean;

import java.io.File;
import java.util.Date;
import java.util.List;

public class UserBeanResult {

	private String firstname;
	private String lastname;
	private Date date_naissance;
	private int AgeRes;
	private Float tailleRes;
	private Boolean QuestionRes;
	private File file;
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public int getAgeRes() {
		return AgeRes;
	}

	public void setAgeRes(int ageRes) {
		AgeRes = ageRes;
	}

	public Float getTailleRes() {
		return tailleRes;
	}

	public void setTailleRes(Float tailleRes) {
		this.tailleRes = tailleRes;
	}

	public Boolean getQuestionRes() {
		return QuestionRes;
	}

	public void setQuestionRes(Boolean questionRes) {
		QuestionRes = questionRes;
	}
}
