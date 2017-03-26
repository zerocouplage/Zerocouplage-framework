package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCPassword is component of ZC , is a password entry box that allow the user to
 * input text information as stars
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public interface ZCPassword extends ZCComponent{

	
	/**
	 * <p> sets the name of the field </p>
	 * @param text
	 */
	public void setName(String text);
	
	/**
	 * <p>Method returns the name of the TextField  </p>
	 * @return name
	 */
	public String getName(); 
	/**
	 * <p>
	 * Method returns the error message of the TextField
	 * </p>
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage();
	/**
	 * <p>
	 * sets the the error message of the TextField
	 * </p>
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage);
	
	/**
	 * <p>
	 * Method to return the field text
	 * </p>
	 * 
	 * @return the text of the field
	 */
	public String getText();

	/**
	 * <p>
	 * Sets the Text of the field
	 * </p>
	 * 
	 * @param The textField name
	 */
	public void setText(String password);
}
  