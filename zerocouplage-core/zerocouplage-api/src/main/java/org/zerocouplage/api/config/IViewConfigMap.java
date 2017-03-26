/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>
 * The collection of views configuration information declared in the
 * Zerocouplage configuration file.
 * </p>
 * 
 */
public interface IViewConfigMap {

	/**
	 * <p>
	 * Returns the IViewConfig instance for the specified viewName
	 * </p>
	 * 
	 * @param viewName
	 *            the viewName by which the IViewConfig instance will be
	 *            retrieved
	 * @return the IViewConfig instance stored with the supplied viewName
	 */
	public IViewConfig getViewConfigByName(String viewName);

	/**
	 * <p>
	 * Returns the IViewConfig instance for the supplied class name
	 * </p>
	 * 
	 * @param viewClassName
	 *            the viewClassName by which the IViewConfig instance will be
	 *            retrieved
	 * @return the IViewConfig instance stored whose class name matches the
	 *         supplied one
	 */
	public IViewConfig getViewConfigByClassName(String viewClassName);

	/**
	 * <p>
	 * Add a new view configuration instance to the collection
	 * </p>
	 * 
	 * @param viewConfig
	 *            IViewConfig instance to be added
	 */
	public void addViewConfig(IViewConfig viewConfig);

	/**
	 * <p>
	 * Remove the IViewConfig instance for the specified viewName
	 * </p>
	 * 
	 * @param viewName
	 *            the name whose associated IViewConfig instance is to be
	 *            removed
	 */
	public void removeViewConfig(String viewName);

	/**
	 * <p>
	 * Returns a Map of IViewConfig instance
	 * </p>
	 * 
	 * @return a Map of IViewConfig instance
	 */
	public Map<String, IViewConfig> getViewConfigs();

	/**
	 * <p>
	 * Set the Map of view configuration instance specified
	 * </p>
	 * 
	 * @param viewConfigs
	 *            the Map of view configuration instance
	 */
	public void setViewConfigs(Map<String, IViewConfig> viewConfigs);

}