package org.zerocouplage.component.api.layout;

import org.zerocouplage.component.api.component.ZCComponent;

/**
 * <p>
 * Grid Bag Layout of zeroCouplage, ZCComponents are added depending on the
 * layout size starting
 * </p>
 * 
 * @author Taoufik RIFAI
 * 
 */

public interface ZCGridBagLayout extends ZCLayout {

	/**
	 * <p>
	 * Adds the ZCComponent to the layout
	 * </p>
	 * 
	 * @param component
	 */
	public void addComponent(ZCComponent component);
	
	/**
	 * <p>
	 * Sets the Grid Bag Layout size
	 * </p>
	 * 
	 * @param X_direction 
	 * @param Y_direction 
	 */
	public void setSize(int x, int y);

}
