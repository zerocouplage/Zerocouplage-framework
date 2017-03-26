package org.zerocouplage.component.api.component;

/**
 * <p>
 * ZCFile is component of ZC , it's a file entry box that allow the user to
 * upload files
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public interface ZCFile extends ZCComponent {

	
	final static String Filter_Image = "image/*";
	final static String Filter_Video = "video/*";
	final static String Filter_Audio = "audio/*";
	final static String Filter_AllFiles = "AllFiles/*";
	
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
	 * Method returns the filter of the component
	 * </p>
	 * 
	 */
	public String getFilter();
	/**
	 * <p>
	 * sets the filter of the component
	 * </p>
	 * 
	 */
	public void setFilter(String Filter);

	
}
