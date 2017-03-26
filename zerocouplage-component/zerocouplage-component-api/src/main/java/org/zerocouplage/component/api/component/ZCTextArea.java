package org.zerocouplage.component.api.component;


/**
 * <p>
 * ZCTextArea is component of ZC , is a area entry  that allow the user to
 * input text information
 * </p>
 * @author ZCTeam 2014
 */
public interface ZCTextArea extends ZCComponent{

	/**
	 * <p> Sets the Text on the area </p> 
	 * @param text on the Area
	 */
	public void setText(String text);

	/**
	 *  <p> Gets the Text on the area </p> 
	 * @return text of the area
	 */
	public String getText(); 
	
	/**
	 * <p> sets the name of the Area </p>
	 * @param text
	 */
	public void setName(String text);

	/**
	 * <p> Gets the Name on the area </p> 
	 * @return Name of the area
	 */
	public String getName();

	
}