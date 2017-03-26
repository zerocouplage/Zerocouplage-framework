package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCRadioButton;

/**
 * <p>
 * ZCAbstractRadioButton is an implementation of the ZCRadioButton
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractRadioButton extends ZCAbstractComponent
		implements ZCRadioButton {

	private boolean checked = false;
	private String name;
	private String value;
	private String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public String getValue() {

		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String txt) {
		this.text = txt;
	}

}
