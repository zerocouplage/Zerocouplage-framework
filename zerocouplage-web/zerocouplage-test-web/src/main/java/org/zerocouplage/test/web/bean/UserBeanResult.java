package org.zerocouplage.test.web.bean;

import java.io.File;
import java.util.Date;
import java.util.List;

public class UserBeanResult {

	private String firstname;
	private String lastname;
	private Integer ageout;
	private Date birthday;
	private float tail;
    private Boolean questionout;
    private File file;
   
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Boolean getQuestionout() {
		return questionout;
	}

	public void setQuestionout(Boolean questionout) {
		this.questionout = questionout;
	}

	public float getTail() {
		return tail;
	}

	public void setTail(float tail) {
		this.tail = tail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAgeout() {
		return ageout;
	}

	public void setAgeout(Integer ageout) {
		this.ageout = ageout;
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
