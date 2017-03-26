/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>The collection of beans configuration information declared in the Zerocouplage
 * configuration file.</p>
 *
 */
public interface IBeanConfigMap {

	/**
	 * <p>Returns the IBeanConfig whose name is specified</p>
	 * 
	 * @param beanName the name to be used when creating a bean configuration instance
	 * @return the bean configuration instance
	 */
	public IBeanConfig getBeanConfigByName(String beanName);

	/**
	 * <p>Add a new bean configuration instance to the collection</p>
	 * 
	 * @param beanConfig the new bean configuration instance to be added
	 */
	public void addBeanConfig(IBeanConfig beanConfig);

	/**
	 * <p>Remove the IBeanConfig instance whose name is specified.</p>
	 * 
	 * @param beanName the name of the IBeanConfig instance to be removed
	 */
	public void removeBeanConfig(String beanName);

	/**
	 * <p>Returns a set of IBeanConfig instance.</p>
	 * 
	 * @return a set of bean configuration instance
	 */
	public Map<String, IBeanConfig> getBeanConfigs();
	
	/**
	 * <p>Set the set of IBeanConfig instance specified</p>
	 * 
	 * @param beanConfigs the map to set 
	 */
	public void setBeanConfigs(Map<String, IBeanConfig> beanConfigs);

}