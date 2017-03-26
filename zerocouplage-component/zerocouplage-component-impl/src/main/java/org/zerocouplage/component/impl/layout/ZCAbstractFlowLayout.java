package org.zerocouplage.component.impl.layout;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.layout.ZCFlowLayout;

/**
 * <p>
 * ZCAbstractFlowLayout is an implementation of the ZCFlowLayout
 * </p>
 * 
 * @author Taoufik RIFAI
 * 
 */
public abstract class ZCAbstractFlowLayout extends ZCAbstractLayout implements
		ZCFlowLayout {

	private String name;
	private ArrayList<ZCComponent> component = new ArrayList<ZCComponent>();
	private int direction;

	public void addComponent(ZCComponent component) throws Exception {
		component.setParentName(this.getParentName());
		component.setParent(this);
		this.component.add(component);

	}

	public ZCComponent getComponent(int id) {
		ZCComponent tmpComponent = null;
		if (component.size() >= id) {
			tmpComponent = (ZCComponent) component.get(id);
		}
		return tmpComponent;

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public ArrayList<ZCComponent> getComponent() {
		return component;
	}

	public void setComponent(ArrayList<ZCComponent> component) {
		this.component = component;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

}
