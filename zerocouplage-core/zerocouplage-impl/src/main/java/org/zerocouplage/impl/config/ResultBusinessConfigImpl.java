/**
 * 
 */
package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.IResultBusinessConfig;
import org.zerocouplage.api.config.IViewConfig;

/**
 * <p>The configuration information of a result business element from the Zerocouplage configuration file.
 * IResultBusinessConfig contains information returned by the execution of business for a specific request
 * </p>
 *
 *
 * @author Guelmbaye Djikoloum
 * 
 */
public class ResultBusinessConfigImpl implements IResultBusinessConfig {

	/**
	 * <p>The result business name</p>
	 */
	private String name;

	/**
	 * <p>The result bean name</p>
	 */
	private String beanName;

	/**
	 * <p>The view configuration associated with this result business</p>
	 */
	private IViewConfig viewConfig;
	
	/**
	 * <p>Constructor for ResultBusinessConfigImpl</p>
	 */
	public ResultBusinessConfigImpl() {
		super();
		this.name = "";
		this.beanName = "";
		this.viewConfig = new ViewConfigImpl();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getBeanName() {
		return this.beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public IViewConfig getViewConfig() {
		return this.viewConfig;
	}

	@Override
	public void setViewConfig(IViewConfig viewConfig) {
		this.viewConfig = viewConfig;
	}

}
