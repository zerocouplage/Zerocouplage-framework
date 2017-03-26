package org.zerocouplage.component.api.component;


/**
 * <p>
 * ZCImage is a component of ZC , it's an image that can be used in web,
 * desktop,mobile or other platforms
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCImage extends ZCComponent {
	/**
	 * <p>
	 * Returns the source of the ZCImage
	 * </p>
	 * 
	 * @return String
	 */
	public String getSource();

	/**
	 * <p>
	 * Sets the source of the ZCImage
	 * </p>
	 * 
	 * @param S
	 */
	public void setSource(String S);
	/**
	 * <p>
	 * Returns the Alt of the ZCImage
	 * </p>
	 * 
	 * @return String
	 */
	public String getAlt();

	/**
	 * <p>
	 * Sets the Alt of the ZCImage
	 * </p>
	 * 
	 * @param alt
	 */
	public void setAlt(String alt);
	/**
	 * <p>
	 * Gets the class of the ZCImage
	 * </p>
	 * 
	 * @return Class
	 */
	public Class getImageClass();
	/**
	 * <p>
	 * Sets the class of the ZCImage
	 * </p>
	 */
	public void setImageClass(Class imageClass);
}