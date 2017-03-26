/**
 * 
 */
package org.zerocouplage.api.config;

/**
 * <p>A JavaBean representing the configuration information of a bean
 * element in Zecocouplage configuration file.</p>
 *
 */
public interface IBeanConfig {

	/**
	 * <p>Returns the name to be used when creating a bean instance.</p>
	 * 
	 * @return String representing the name to be used when creating a bean instance.
	 */
	public String getBeanName();

	/**
	 * <p>the name to be used when creating a bean instance.</p>
	 * 
	 * @param beanName name to be used when creating a bean instance.
	 */
	public void setBeanName(String beanName);

	/**
	 * <p>Returns the class name to be used when creating a bean instance.</p>
	 * 
	 * @return a String representing the class name to be used when creating a bean instance.
	 */
	public String getClassName();

	/**
	 * <p>The class name to be used when creating a bean instance.</p>
	 * 
	 * @param className class name to be used when creating a bean instance.
	 */
	public void setClassName(String className);

}