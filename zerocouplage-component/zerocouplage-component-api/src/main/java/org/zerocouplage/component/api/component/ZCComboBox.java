package org.zerocouplage.component.api.component;

import java.util.ArrayList;

/**
 * <p>
 * ZCComboBox is a component of ZC . It is a list of box
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCComboBox extends ZCComponent {
	
	/**<p>
	 * Method which adds an item to the component
	 * </p>
	 * @param item
	 */
	public void addComboboxItem(ZCComboBoxItem item);

	/**<p>
	 * Method which returns a list of items used by the component
	 * </p>
	 * @param item
	 */
	public ArrayList<ZCComboBoxItem> getItems();
	/**
	 * <p>
	 * sets the name of the component
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
	 * Method returns the name of the selected item
	 * </p>
	 * 
	 * @return name
	 */
	public String getSelectedName();
	/**
	 * <p>
	 * sets the name of the selected item
	 * </p>
	 * 
	 * @param item
	 */
	public void setSelectedName(ZCComboBoxItem item);
	

}
