package org.zerocouplage.component.api.component;




/**
 * <p>
 * ZCTitle is component that can be used to set a title in web,
 * desktop,mobile or other platforms
 * </p>
 * 
 * @author 
 * 
 */
public interface ZCTitle extends ZCComponent {
	
	final static String H6 = "10";
	final static String H5 = "20";
	final static String H4 = "40";
	final static String H3 = "60";
	final static String H2 = "80";
	final static String H1 = "100";


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
	 * 
	 * @param name
	 * <p>
	 *  gets the component's Font-width type
	 * </p>
	 * 
	 **/
	public String getHi();

	/**
	 * 
	 * @param name
	 * <p>
	 *  sets the component's Font-width type
	 * </p>
	 * 
	 * @param hi
	 **/
	public void setHi(String hi);

}