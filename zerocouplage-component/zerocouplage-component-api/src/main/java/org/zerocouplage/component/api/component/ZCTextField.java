package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCTextField is component of ZC , is a text entry box that allow the user to
 * input text information
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCTextField extends ZCComponent {

	/**
	 * <p>
	 * Sets the Text of the field
	 * </p>
	 * 
	 * @param The textField name
	 */

	public void setText(String text);

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
	 * sets the name of the field
	 * </p>
	 * 
	 * @param text
	 */
	public void setName(String text);

	/**
	 * <p>
	 * Method returns the name of the TextField
	 * </p>
	 * 
	 * @return name
	 */
	public String getName();
	
	/**
	 * <p>
	 * sets the placeholder of the ZCTextField
	 * </p>
	 * 
	 * @param text
	 */
	public void setPlaceHolder(String ph);

	/**
	 * <p>
	 * Method returns the placeholer of the TextField
	 * </p>
	 * 
	 * @return ph
	 */
	public String getPlaceHolder();
	
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
}
