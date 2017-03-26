/**
 * 
 */
package org.zerocouplage.api.config;

/**
 * 
 * <p>The configuration information of a result business element from the Zerocouplage configuration file.
 * IResultBusinessConfig contains information returned by the execution of business for a specific request
 *
 */
public interface IResultBusinessConfig {

	/**
	 * <p>Returns the name of this IResultBusinessConfig. This name is the result value when a business method is executed</p>
	 * 
	 * @return the name of this IResultBusinessConfig
	 */
	public String getName();

	/**
	 * <p>Set the name of this IResultBusinessConfig.</p>
	 * 
	 * @param name the name of this IResultBusinessConfig
	 */
	public void setName(String name);

	/**
	 * <p>Returns the name IBeanConfig instance.</p>
	 * 
	 * @return the name of IBeanConfig instance 
	 */
	public String getBeanName();

	/**
	 * <p>Set the name IBeanConfig instance.</p>
	 * 
	 * @param beanName the name of IBeanConfig instance
	 */
	public void setBeanName(String beanName);

	/**
	 * <p>Returns IViewConfig instance for this IResultBusinessConfig.</p>
	 * 
	 * @return IViewConfig instance
	 */
	public IViewConfig getViewConfig();

	/**
	 * <p>Set IViewConfig instance for this IResultBusinessConfig.</p>
	 * 
	 * @param viewConfig IViewConfig instance
	 */
	public void setViewConfig(IViewConfig viewConfig);

}
