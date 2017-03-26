package org.zerocouplage.component.api.layout;

import org.zerocouplage.component.api.component.ZCComponent;

/**
 * <p>
 * Base class of all ZeroCouplage layouts
 * </p>
 * 
 * @author Taoufik RIFAI
 * @author Team 2014
 * 
 */

public interface ZCLayout extends ZCComponent {
	/**
	 * <p>
	 * Method which indicate if the page contains a form component or not
	 * </p>
	 */
	public boolean isForm();
	
	/**
	 * <p>
	 * sets the value of form which is true or false
	 * </p>
	 * @param form
	 */
	public void setForm(boolean form);
	/**
	 * <p>
	 * gets name of the component
	 * </p>
	 * @return name
	 */
	public String getName();

	/**
	 * <p>
	 * sets the name of the component
	 * </p>
	 * @param n
	 */
	public void setName(String n);
}
