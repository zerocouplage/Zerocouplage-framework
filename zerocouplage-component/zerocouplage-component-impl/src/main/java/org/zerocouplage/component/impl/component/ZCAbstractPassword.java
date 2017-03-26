package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCPassword;

/**
 * <p>
 * ZCAbstractPassword is an implementation of the ZCPassword
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractPassword extends ZCAbstractComponent implements
		ZCPassword {

	private String name;
	private String errorMessage;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

	public String getText(){
		return password;
	}

	public void setText(String password){
		this.password=password;
	}

}
