package org.zerocouplage.component.api.config;

import java.util.Map;

/**
 * 
 * 
 * @author Nadia ELRHOUL
 * 
 */

public interface ZCCompConfig {

	/**
	 * <p>
	 * The name of the class API
	 * </p>
	 * 
	 * @throws ZCCompNotFoundException
	 */
	public String getClassImpl(String classApi);

	/**
	 * <p>
	 * Sets the class API
	 * </p>
	 * 
	 * @param ClassApi
	 */
	public void setClassApi(String ClassApi);

	/**
	 * 
	 * @return
	 */

	public String getClassApi();

	/**
	 * <p>
	 * Sets the class implement
	 * </p>
	 * 
	 * @param ClassImpl
	 */

	public void setClassImpl(String ClassImpl);

	/**
	 * 
	 * @return classImpl
	 */
	public String getClassImplement();

	/**
	 * <p>
	 * Add the class API and class implements to the map
	 * </p>
	 * 
	 * @param classApi
	 * @param classImpl
	 */

	public void add(String classApi, String classImpl);

	/**
	 * <p>
	 * return the map
	 * </p>
	 * 
	 * @return Map<String, String>
	 */
	public Map<String, String> getcompMaper();

}

