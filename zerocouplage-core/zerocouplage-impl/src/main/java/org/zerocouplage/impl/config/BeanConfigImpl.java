/**
 * 
 */
package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.IBeanConfig;
/**
 * <p>A JavaBean representing the configuration information of a bean
 * element in Zecocouplage configuration file.</p>
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class BeanConfigImpl implements IBeanConfig {

	/**
	 * <p>the JavaBean name</p>
	 */
	private String beanName;

	/**
	 * <p>The JavaBean class name</p>
	 */
	private String className;

	@Override
	public String getBeanName() {
		return this.beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public String getClassName() {
		return this.className;
	}

	@Override
	public void setClassName(String className) {
		this.className = className;
	}

}
