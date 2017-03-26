/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>
 * The configuration information of a business element from the Zerocouplage
 * configuration file.
 * </p>
 * 
 */
public interface IBusinessConfig {

	/**
	 * <p>
	 * Returns the name for this IBusinessConfig specified in Zerocouplage
	 * configuration file.
	 * </p>
	 * 
	 * @return the name of this IBusinessConfig
	 */
	public String getName();

	/**
	 * <p>
	 * Set a name for this IBusinessConfig.
	 * </p>
	 * 
	 * @param name
	 *            business name
	 */
	public void setName(String name);

	/**
	 * <p>
	 * Returns a business class name
	 * 
	 * @return the business class name
	 */
	public String getClassName();

	/**
	 * <p>
	 * Set a class name for this IBusinessConfig.
	 * </p>
	 * 
	 * @param ClassName
	 *            the IBusinessConfig class name
	 */
	public void setClassName(String className);

	/**
	 * <p>
	 * Returns a business method name.
	 * </p>
	 * 
	 * @return the business method name
	 */
	public String getMethodeName();

	/**
	 * <p>
	 * Set a business method name.
	 * </p>
	 * 
	 * @param methodeName
	 *            the business method name
	 */
	public void setMethodeName(String methodeName);

	/**
	 * <p>
	 * Returns a Bean configuration instance for this IBusinessConfig.
	 * </p>
	 * 
	 * @return the IBeanConfig instance
	 */
	public IBeanConfig getInBeanConfig();

	/**
	 * <p>
	 * Set a Bean configuration instance.
	 * </p>
	 * 
	 * @param beanConfig
	 *            the IBeanConfig instance
	 */
	public void setInBeanConfig(IBeanConfig beanConfig);

	/**
	 * <p>
	 * Returns a Map of Validator Configuration instance for this
	 * IBusinessConfig.
	 * </p>
	 * 
	 * @return the Map<String, IValidatorConfig> instance
	 */

	public Map<String, IValidatorConfig> getValidatorConfigs();

	/**
	 * <p>
	 * Set a Map of Validator Configuration instance instance.
	 * </p>
	 * 
	 * @param validatorConfig
	 *            Map<String, IValidatorConfig> instance
	 * @return
	 */

	public void setValidatorConfigs(
			Map<String, IValidatorConfig> validatorConfig);

	/**
	 * <p>
	 * Returns a Validator Configuration instance for this IBusinessConfig.
	 * </p>
	 * 
	 * @return the IValidatorConfig instance
	 */
	public IValidatorConfig getValidatorConfig();

	/**
	 * <p>
	 * Set a Validator Configuration instance instance.
	 * </p>
	 * 
	 * @param validatorConfig
	 *            IValidatorConfig instance
	 */
	public void setValidatorConfig(IValidatorConfig validatorConfig);

	/**
	 * <p>
	 * Returns a Map of IResultBusinessConfig instance
	 * </p>
	 * 
	 * @return the Map of IResultBusinessConfig instance to be returned
	 */
	public Map<String, IResultBusinessConfig> getResultBusinessConfig();

	/**
	 * <p>
	 * Add a new IResultBusinessConfig instance
	 * </p>
	 * 
	 * @param resultBusinessConfig
	 *            the name of the IResultBusinessConfig instance being added
	 */
	public void addResultBusinessConfig(
			IResultBusinessConfig resultBusinessConfig);

	/**
	 * <p>
	 * Returns the IResultBusinessConfig instance for the specified name
	 * </p>
	 * 
	 * @param resultBusinessName
	 *            the name of the IResultBusinessConfig instance
	 * @return IResultBusinessConfig instance whose name is specified
	 */
	public IResultBusinessConfig getResultBusinessConfigByName(
			String resultBusinessName);

	/**
	 * <p>
	 * Remove the IResultBusinessConfig instance whose name is specified.
	 * </p>
	 * 
	 * @param resultBusinessName
	 *            the name of the IResultBusinessConfig
	 */
	public void removeResultBusinessConfigByName(String resultBusinessName);

	/**
	 * <p>
	 * Returns the name of the IViewConfig that makes reference to error page.
	 * </p>
	 * 
	 * @return the name of the IViewConfig
	 */
	public String getPageError();

	/**
	 * <p>
	 * Set the name of the IViewConfig that makes reference to error page.
	 * </p>
	 * 
	 * @param pageError
	 *            the name of the IViewConfig that makes reference to error page
	 */

	public void setPageError(String pageError);

}