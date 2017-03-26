package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCRadioButton component of ZC ,that allows the user to choose only one of a
 * predefined set of options
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCRadioButton extends ZCComponent {
	/**
	 * <p> Sets the Name of the ZCRadioButton </p> 
	 * @param name
	 */
	public void setName(String name);
	/**
	 *  <p> Gets the Name of the component </p> 
	 * @return the Name of the component
	 */
	public String getName();

	/**
	 * <p> Sets the Value of the component </p> 
	 * @param value of the component
	 */
	public void setValue(String value);

	/**
	 *  <p> Gets the Value of the component </p> 
	 * @return value of the component
	 */
	public String getValue();

	/**
	 * <p>
	 * Returns the radio button check by default
	 * </p>
	 * 
	 * @return checked
	 */
	public boolean isChecked();

	/**
	 * <p>
	 * Sets the checked default component
	 * </p>
	 * 
	 * @param checked
	 */

	public void setChecked(boolean checked);
	/**
	 * <p>
	 * Gets the text which appear near of the component
	 * </p>
	 */
	public String getText();

	/**
	 * <p>
	 * Sets the text which appear near of the component
	 * </p>
	 * 
	 * @param txt
	 * 
	 */


	public void setText(String txt);


}

   