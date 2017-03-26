package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCComboBoxItem;

/**
 * <p>
 * ZCAbstractComboBoxItem is an implementation of the ZCComboBoxItem
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractComboBoxItem extends ZCAbstractComponent
		implements ZCComboBoxItem {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
