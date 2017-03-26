package org.zerocouplage.component.impl.layout;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.layout.ZCBorderLayout;

/**
 * <p>
 * ZCAbstractBorderLayout is an implementation of the ZCBorderLayout
 * </p>
 * 
 * @author Taoufik RIFAI
 * 
 */
public abstract class ZCAbstractBorderLayout extends ZCAbstractLayout implements
		ZCBorderLayout {

	private ArrayList<ZCComponent> componentCenter = new ArrayList<ZCComponent>();
	private ArrayList<ZCComponent> componentNorth = new ArrayList<ZCComponent>();
	private ArrayList<ZCComponent> componentSouth = new ArrayList<ZCComponent>();
	private ArrayList<ZCComponent> componentEast = new ArrayList<ZCComponent>();
	private ArrayList<ZCComponent> componentWest = new ArrayList<ZCComponent>();

	private boolean Form;
	private String name;

	public boolean isForm() {
		return Form;
	}

	public void setForm(boolean form) {
		Form = form;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public ArrayList<ZCComponent> getComponentCenter() {

		return componentCenter;
	}

	public void addComponentCenter(ZCComponent componentCenter) {
		componentCenter.setParentName(this.getParentName());
		this.componentCenter.add(componentCenter);
	}

	public ArrayList<ZCComponent> getComponentNorth() {

		return componentNorth;
	}

	public void addComponentNorth(ZCComponent componentNorth) {
		componentNorth.setParentName(this.getParentName());
		this.componentNorth.add(componentNorth);
	}

	public ArrayList<ZCComponent> getComponentSouth() {
		return componentSouth;
	}

	public void addComponentSouth(ZCComponent componentSouth) {
		componentSouth.setParentName(this.getParentName());
		this.componentSouth.add(componentSouth);
	}

	public ArrayList<ZCComponent> getComponentEast() {
		return componentEast;
	}

	public void addComponentEast(ZCComponent componentEast) {
		componentEast.setParentName(this.getParentName());
		this.componentEast.add(componentEast);
	}

	public ArrayList<ZCComponent> getComponentWest() {
		return componentWest;
	}

	public void addComponentWest(ZCComponent componentWest) {
		componentWest.setParentName(this.getParentName());
		this.componentWest.add(componentWest);
	}

}
