/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>The collection of business configuration information declared in the Zerocouplage
 *configuration file.</p>
 *
 */
public interface IBusinessConfigMap {
	
	/**
	 * <p>Returns the IBusinessConfig whose name is specified</p>
	 * 
	 * @param businessName the name associated with the IBusinessConfig instance to be returned
	 * @return the IBusinessConfig instance stored with the supplied key
	 */
	public IBusinessConfig getBusinessConfigByName(String businessName);

	/**
	 * <p>Add a new IBusinessConfig instance to the collection</p>
	 * 
	 * @param businessConfig IBusinessConfig instance being added
	 */
	public void addBusinessConfig(IBusinessConfig businessConfig);

	/**
	 * <p>Removes the IBusinessConfig for the specified name</p>
	 * 
	 * @param businessName the name of the IBusinessConfig
	 */
	public void removeBusinessConfig(String businessName);

	/**
	 * <p>Returns a Map of IBusinessConfig instance</p>
	 * 
	 * @return the Map of IBusinessConfig instance to be returned
	 */
	public Map<String, IBusinessConfig> getBusinessConfigs();
	
	/**
	 * <p>Set a Map of IBusinessConfig instance</p>
	 * 
	 * @param businessConfigs the Map of IBusinessConfig instance
	 */
	public void setBusinessConfigs(Map<String, IBusinessConfig> businessConfigs);

}