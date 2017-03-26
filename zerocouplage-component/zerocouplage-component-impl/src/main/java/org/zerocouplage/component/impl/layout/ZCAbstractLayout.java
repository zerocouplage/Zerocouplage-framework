package org.zerocouplage.component.impl.layout;

import org.zerocouplage.component.api.layout.ZCLayout;
import org.zerocouplage.component.api.style.IZCStyle;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.style.ZCStyle;

/**
 * <p>
 * ZCAbstractLayout is an implementation of the ZCLayout
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractLayout extends ZCAbstractComponent implements
		ZCLayout {
	private boolean form;
	private String name;
	private IZCStyle style;

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IZCStyle getStyle() {
		if (style == null) {
			style = new ZCStyle();
		}
		return style;
	}

	public void setStyle(IZCStyle style) {
		this.style = style;
	}

}
