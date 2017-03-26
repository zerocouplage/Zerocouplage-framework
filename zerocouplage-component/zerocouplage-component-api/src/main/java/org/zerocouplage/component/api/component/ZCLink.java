package org.zerocouplage.component.api.component;





/**
 * <p>
 * ZCLink is component that can be used to create a HyperTextLink in web,
 * desktop,mobile or other platforms
 * </p>
 * 
 * @author 
 * 
 */

public interface ZCLink extends ZCComponent {

	/**
	 * <p>
	 * Sets the component's Text
	 * </p>
	 * 
	 * @param s
	 */

	public void setText(String s);


	/**
	 * <p>
	 * Returns the component's text setting by the user
	 * </p>
	 * 
	 * @return text
	 */
	public String getText();

	/**
	 * <p>
	 *  Sets the component's name
	 * </p>
	 * @param name
	 **/
	public void setName(String name);

	/**
	 * <p>
	 * Returns the component's name
	 * </p>
	 * 
	 * @return name
	 */
	public String getName();


	

	/**
	 * <p>
	 * Sets the action of the component
	 * </p>
	 * 
	 * @param actionName
	 * @param thisClass
	 */
	public void setAction(String actionName, Object thisClass);


	/**
	 * <p>
	 * Returns the component's action
	 * </p>
	 * 
	 * @return action
	 */
	public String getAction();
}