package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCCheckBox is component of zeroCouplage, is a box that can be checked by a
 * user
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCCheckBox extends ZCComponent {
	/**
	 * <p>
	 * return the name of the component
	 * </p>
	 * 
	 * @return name
	 * 
	 */

	public String getName();

	/**
	 * <p>
	 * sets the name of the component
	 * </p>
	 * 
	 * @param name
	 * 
	 */
	public void setName(String name);

	/**
	 * 
	 * @return value of ZCCheckBox
	 */

	public String getText();

	/**
	 * <p>
	 * sets the text which appear near of the component
	 * </p>
	 * 

	public void setText(String txt);

	/**
	 * 
	 * @return <p>
	 * 				return the status of the checkBox
     * 			</p>
	 */
	public boolean isChecked();

	/**
	 * <p>
	 * sets the checked default component
	 * </p>
	 * 
	 * @param checked
	 */

	public void setChecked(boolean checked);
	
	/**
	 * 
	 * @return
	 */
	public String getAction();

	/**
	 * 
	 * @param a
	 * @param thisClass
	 */
	public void setAction(String a, Object thisClass);

}
