package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.style.IZCStyle;
import org.zerocouplage.component.impl.style.ZCStyle;

/**
 * <p>
 * ZCAbstractComponent is an implementation of the ZCComponent
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractComponent implements ZCComponent {

	private IZCStyle style;
	private String idComponent;
	private String ParentName;
	private ZCComponent Parent;

	public void setStyle(IZCStyle pStyle) {
		style = pStyle;
	}

	public IZCStyle getStyle() {
		if (style == null) {
			style = new ZCStyle();
		}
		return style;
	}

	public abstract Object display() throws Exception;

	public String getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}

	public String getParentName() {
		return ParentName;
	}

	public void setParentName(String parentName) {
		ParentName = parentName;
	}

	public ZCComponent getParent() {
		return Parent;
	}

	public void setParent(ZCComponent parent) {
		Parent = parent;
	}

}
