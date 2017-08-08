package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCCheckBox;

/**
 * <p>
 * ZCAbstractCheckBox is an implementation of the ZCCheckBox
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public abstract class ZCAbstractCheckBox extends ZCAbstractComponent implements
		ZCCheckBox {

	protected String action;
	private String name;
	private String text;
	private boolean checked = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String txt) {
		this.text = txt;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}
}
