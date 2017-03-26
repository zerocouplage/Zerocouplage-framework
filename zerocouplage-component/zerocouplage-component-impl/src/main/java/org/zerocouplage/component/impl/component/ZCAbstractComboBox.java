package org.zerocouplage.component.impl.component;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComboBox;
import org.zerocouplage.component.api.component.ZCComboBoxItem;


/**
 * <p>
 * ZCAbstractComboBox is an implementation of the ZCComboBox
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractComboBox extends ZCAbstractComponent implements
		ZCComboBox {

	private ArrayList<ZCComboBoxItem> items = new ArrayList<ZCComboBoxItem>();
	private String name;

	public void addComboboxItem(ZCComboBoxItem item) {
		this.items.add(item);
	}

	public ArrayList<ZCComboBoxItem> getItems() {
		return items;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
