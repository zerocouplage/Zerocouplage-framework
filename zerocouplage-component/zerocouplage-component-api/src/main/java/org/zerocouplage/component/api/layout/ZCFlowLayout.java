package org.zerocouplage.component.api.layout;

import org.zerocouplage.component.api.component.ZCComponent;

/**
 * <p>
 * Flow Layout of zeroCouplage, ZCComponents are added weather on X Direction or
 * Y Direction, with an undefined number
 * </p>
 * 
 * @author Taoufik RIFAI
 * 
 */
public interface ZCFlowLayout extends ZCLayout {

	/**
	 * <p>X direction setting on 1</p>
	 */
	final static int X_DIRECTION = 1;

	/**
	 * <p>Y direction setting on 0</p>
	 */
	final static int Y_DIRECTION = 0;

	/**
	 * <p>
	 * Adds the ZCComponent to the Layout
	 * </p>
	 * 
	 * @param component
	 * @throws Exception 
	 */
	public void addComponent(ZCComponent component) throws Exception;

	/**
	 * <p>
	 * Sets the Flow direction
	 * </p>
	 * <ul>
	 * <li>1 defining ZCFlowLayout.X_DIRECTION</li>
	 * <li>0 defining ZCFlowLayout.Y_DIRECTION</li>
	 * </ul>
	 * 
	 * @param direction
	 */
	public void setDirection(int direction);
	



}
