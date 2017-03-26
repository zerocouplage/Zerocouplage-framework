package org.zerocouplage.component.api.layout;

import org.zerocouplage.component.api.component.ZCComponent;

/**
 * <p>
 * Border Layout of zeroCouplage, composed of 5 areas Center, North,
 * South, East and West in which ZCComponents are added
 * </p>
 * 
 * @author Taoufik RIFAI
 * 
 */

public interface ZCBorderLayout extends ZCLayout {

	/**
	 * <p>
	 * adds the Center ZCComponent
	 * </p>
	 * 
	 * @param component Center
	 */
	public void addComponentCenter(ZCComponent component);

	/**
	 * <p>
	 * adds the North ZCComponent
	 * </p>
	 * 
	 * @param component North
	 */
	public void addComponentNorth(ZCComponent component);

	/**
	 * <p>
	 * adds the South ZCComponent
	 * </p>
	 * 
	 * @param component South
	 */
	public void addComponentSouth(ZCComponent component);

	/**
	 * <p>
	 * adds the West ZCComponent
	 * </p>
	 * 
	 * @param component West
	 */
	public void addComponentWest(ZCComponent component);

	/**
	 * <p>
	 * adds the East ZCComponent
	 * </p>
	 * 
	 * @param component East
	 */
	public void addComponentEast(ZCComponent component);
	
	


}