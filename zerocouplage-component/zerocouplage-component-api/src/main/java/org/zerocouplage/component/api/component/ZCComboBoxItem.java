package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCComboBoxItem is a component of ZC . It is a Item of ZCComboBox
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCComboBoxItem extends ZCComponent {
	/**
	 * <p>
	 * The value of component
	 * </p>
	 * 
	 * @param value
	 * 
	 */
	public void setValue(String value);

	/**
	 * <p>
	 * The index of the item in the component
	 * </p>
	 * 
	 * @param index
	 * @return
	 */

	public String getValue();

}
