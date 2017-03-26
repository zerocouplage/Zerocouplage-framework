package org.zerocouplage.component.api.component;

import org.zerocouplage.component.api.style.IZCStyle;
/**
 * <p>
 * ZCComponent is basic of all components , contains a common methods
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCComponent {

	
	/**
	 * <p>
	 * The style of the component
	 * </p>
	 * 
	 * @param style
	 * 
	 */
	public void setStyle(IZCStyle style);

	/**
	 * <p>
	 * Returns the style of the component
	 * </p>
	 * 
	 * @return style
	 */

	public IZCStyle getStyle();

	/**
	 * <p>
	 * Returns the id of the component
	 * </p>
	 * 
	 * @return idComponent
	 */

	public String getIdComponent();

	/**
	 * <p> Sets the ID of the component</p>
	 * @param id
	 */

	public void setIdComponent(String id);
	/**
	 * <p>Method returns that created component </p>
	 * @return Requested object
	 * @throws Exception 
	 */

	public Object display() throws Exception ;
	/**
	 * <p>
	 * Returns the parentName of the component
	 * </p>
	 * 
	 * @return parentName
	 */
	public String getParentName();
	/**
	 * <p> Sets the parentName of the component</p>
	 * @param name
	 */
	public void setParentName(String name);
	/**
	 * <p>
	 * Returns the Parent of the component
	 * </p>
	 * 
	 * @return Parent
	 */
	public ZCComponent getParent();
	/**
	 * <p> Sets the Parent of the component</p>
	 * @param component
	 */
	public void setParent(ZCComponent component);
	
}
