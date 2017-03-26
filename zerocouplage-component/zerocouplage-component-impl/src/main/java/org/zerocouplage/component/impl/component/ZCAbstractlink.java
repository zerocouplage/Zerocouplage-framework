package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCLink;
/**
 * <p>
 * ZCAbstractlink is an implementation of the ZCLink
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractlink extends ZCAbstractComponent implements
		ZCLink {

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
