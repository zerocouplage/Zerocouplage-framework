package org.zerocouplage.component.api.component;




/**
 * <p>
 * ZCButton is component of zeroCouplage , that can be used in web,
 * desktop,mobile or other platforms
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public interface ZCButton extends ZCComponent {
	/**
	 * <p>
	 * Sets the component's Text
	 * </p>
	 * 
	 * 
	 */

	public void setText(String s);

	/**
	 * <p>
	 * Returns the component text setting by the user
	 * </p>
	 * 
	 * @return ZCButton Text
	 */
	public String getText();

	/**
	 * 
	 * @param name
	 *            <p>
	 *            Sets the component name
	 *            </p>
	 * 
	 **/
	public void setName(String name);

	/**
	 * <p>
	 * Returns the component name
	 * </p>
	 * 
	 * @return button name
	 */
	public String getName();


	

	/**
	 * <p>
	 * Sets the action on the ZCButton for web
	 * </p>
	 * 
	 * @param actionName
	 */
	public void setAction(String actionName, Object thisClass);

	/**
	 * <p>
	 * Returns the Action applied on the ZCButton
	 * </p>
	 * 
	 * @return Action on ZCbutton
	 */
	public String getAction();
}