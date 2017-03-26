package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCLabel;

/**
 * <p>
 * ZCAbstractLabel is an implementation of the ZCLabel
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractLabel extends ZCAbstractComponent implements
		ZCLabel {

	/**
	 * <p>
	 * The component label
	 * </p>
	 */

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
