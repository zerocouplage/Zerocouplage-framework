package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCLabel is component of ZC
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public interface ZCLabel extends ZCComponent {

	/**
	 * <p>
	 * sets The label's text
	 * </p>
	 * 
	 * @param label
	 */

	public void setLabel(String label);

	/**
	 * <p>
	 * gets The label's text
	 * </p>
	 * @return label
	 */
	public String getLabel();
}
