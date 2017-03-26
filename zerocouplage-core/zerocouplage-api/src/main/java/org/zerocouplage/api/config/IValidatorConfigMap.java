/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>The collection of IValidatorConfig information declared in the Zerocouplage
 * configuration file, zerocouplage.xml.</p>
 *
 */
public interface IValidatorConfigMap {
	
	/**
	 * <p>Returns the IValidatorConfig instance for the supplied validatorName</p>
	 * 
	 * @param validatorName the name by which the IValidatorConfig instance will be retrieved
	 * @return the IValidatorConfig instance stored with the supplied viewName
	 */
	public IValidatorConfig getValidatorConfigByName(String validatorName);

	/**
	 * <p>Add a new validator configuration instance to the collection</p>
	 * 
	 * @param validatorConfig IValidatorConfig instance to be added
	 */
	public void addValidatorConfig(IValidatorConfig validatorConfig);

	/**
	 * <p>Removes the IValidatorConfig for the specified validatorName</p>
	 * 
	 * @param validatorName the name of validator configuration instance to be removed
	 */
	public void removeValidatorConfig(String validatorName);

	/**
	 * <p>Returns a Map of IValidatorConfig instance</p>
	 * 
	 * @return a Map of IValidatorConfig instance
	 */
	public Map<String, IValidatorConfig> getValidatorConfigs();

	/**
	 * <p>Set the Map of validator configuration instance for this IValidatorConfigMap </p>
	 * 
	 * @param validatorConfigs the Map of validator configuration instance
	 */
	public void setValidatorConfigs(
			Map<String, IValidatorConfig> validatorConfigs);
}
