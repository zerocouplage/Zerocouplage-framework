package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCTextArea;

/**
 * <p>
 * ZCAbstractTextArea is an implementation of the ZCTextArea
 * </p>
 * @author ZCTeam 2014
 */
public abstract class ZCAbstractTextArea extends ZCAbstractComponent implements
		ZCTextArea {

	private String text;

	private String name;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setName(String text) {
		this.name = text;
	}

	public String getName() {
		return name;
	}

}
