package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCTextField;


/**
 * <p>
 * ZCAbstractTextField is an implementation of the ZCTextField
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractTextField extends ZCAbstractComponent implements
		ZCTextField {

	private String text;
	private String name;
	private String placeholder;
	private String errorMessage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPlaceHolder(String ph) {
		this.placeholder = ph;
	}

	public String getPlaceHolder() {
		return placeholder;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
