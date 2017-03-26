package org.zerocouplage.component.api.layout;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComponent;

/**
 * <p>
 * Grid Layout of zeroCouplage
 * </p>
 * 
 * @author  ZCTeam 2014
 * 
 */
public interface ZCGridLayout extends ZCLayout {

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
	 * gets columns of the component
	 * </p>
	 * 
	 * @return columns
	 * 
	 */
	public int getCols();

	/**
	 * <p>
	 * sets columns of the component
	 * </p>
	 * 
	 * @param Cols
	 * 
	 */
	public void setCols(int cols);

	/**
	 * <p>
	 * gets rows of the component
	 * </p>
	 * 
	 * @return rows
	 * 
	 */
	public int getRows();

	/**
	 * <p>
	 * sets rows of the component
	 * </p>
	 * 
	 * @param rows
	 * 
	 */
	public void setRows(int rows);

	}


	