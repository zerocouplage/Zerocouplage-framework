package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCButton;

/**
 * <p>
 * ZCAbstractButton is an implementation of the ZCButton
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */



public abstract class ZCAbstractButton extends ZCAbstractComponent implements
		ZCButton {

	private String text;
	protected String action;
	private String name;

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

}
