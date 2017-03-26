package org.zerocouplage.component.api.component;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * <p>
 * ZCTable is component of ZC , it's a table that can be used in web,
 * desktop,mobile or other platforms
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public interface ZCTable extends ZCComponent{
	
	/**
	 * <p>
	 * sets the head of the ZCTabe
	 * </p>
	 * 
	 */
	public void setHead(ArrayList<String> data);
	
	/**
	 * <p>
	 * Method returns a list of head elements
	 * </p>
	 * 
	 * @return head of ZCTable
	 */
	public ArrayList<String> getHead();
	
	/**
	 * <p>
	 * sets the core of the ZCTabe
	 * </p>
	 * 
	 */
	public void setCore(Array[][] coreData);
	
	/**
	 * <p>
	 * Method returns the core of the ZCTabe
	 * </p>
	 * 
	 * @return core of ZCTable
	 */
	public Array[][] getCore();
	
}