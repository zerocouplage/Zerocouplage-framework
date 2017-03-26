/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>A collection of IMapBeanViewConfig configuration information declared in the Zerocouplage
 * configuration file, zerocouplage.xml</p>
 *
 */
public interface IMapBeanViewConfigMap {

	/**
	 * <p>Returns the IMapBeanViewConfig instance which maps IBeanConfig and IViewConfig whose names are specified.</p>
	 * 
	 * @param beanName the IBeanConfig name
	 * @param viewName the IViewConfig name
	 * @return IMapBeanViewConfig instance
	 */
	public IMapBeanViewConfig getMapBeanViewConfig(String beanName,
			String viewName);

	/**
	 * <p>Add a new IMapBeanViewConfig instance to the collection</p>
	 * 
	 * @param mapBeanViewConfig IMapBeanViewConfig instance
	 */
	public void addMapBeanViewConfig(IMapBeanViewConfig mapBeanViewConfig);

	/**
	 * <p>Removes the IMapBeanViewConfig for the specified idMapBeanView.</p> 
	 * 
	 * @param idMapBeanView the IMapBeanViewConfig id
	 */
	public void removeMapBeanViewConfig(String idMapBeanView);

	/**
	 * <p>Returns a Map of IMapBeanViewConfig instance.</p>
	 * 
	 * @return the Map of IMapBeanViewConfig instance
	 */
	public Map<String, IMapBeanViewConfig> getMapBeanViewConfigs();

	/**
	 * <p>Set a Map of IMapBeanViewConfig instance.</p>
	 * 
	 * @param mapBeanViewConfigs the Map of IMapBeanViewConfig
	 */
	public void setMapBeanViewConfigs(
			Map<String, IMapBeanViewConfig> mapBeanViewConfigs);
	
}