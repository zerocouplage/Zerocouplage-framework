package org.zerocouplage.component.api.style;

/**
 * <p>
 * The interface style of a ZCComponent, it contains methods for setting the width, height and color of the ZCComponent  
 * </p>
 * 
 * @author Yassine ABDELJALIL
 * 
 */

public interface IZCStyle {

	/**
	 * <p>
	 * The method of setting width
	 * </p>
	 * 
	 * @param width
	 */

	public void setWidth(int width);

	/**
	 * <p>
	 * The method of setting height
	 * </p>
	 * 
	 * @param height
	 */

	public void setHeight(int height);

	/**
	 * <p>
	 * The method of setting color
	 * </p>
	 * 
	 * @param color
	 */

	public void setColor(String color);

	/**
	 * <p>
	 * The method of getting width
	 * </p>
	 * 
	 * @return
	 */

	public int getWidth();

	/**
	 * 
	 * <p>
	 * The method of getting height
	 * </p>
	 * 
	 * @return width
	 */

	public int getHeight();

	/**
	 * <p>
	 * The method of getting color
	 * </p>
	 * 
	 * @return color
	 */

	public String getColor();
}
