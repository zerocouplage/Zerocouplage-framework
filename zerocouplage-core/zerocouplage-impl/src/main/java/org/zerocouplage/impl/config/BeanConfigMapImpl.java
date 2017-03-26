/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IBeanConfig;
import org.zerocouplage.api.config.IBeanConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * The collection of beans configuration (IBeanConfig) information declared in
 * the Zerocouplage configuration file.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class BeanConfigMapImpl implements IBeanConfigMap {

	/**
	 * The set of IBeanConfig instances</p>
	 */
	private Map<String, IBeanConfig> beanConfigs;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(BeanConfigMapImpl.class);

	/**
	 * <p>
	 * Constructor for BeanConfigMapImpl
	 * </p>
	 */
	protected BeanConfigMapImpl() {
		super();
		this.beanConfigs = new HashMap<String, IBeanConfig>();
	}

	@Override
	public IBeanConfig getBeanConfigByName(String beanName) {
		return ((IBeanConfig) beanConfigs.get(beanName));
	}

	@Override
	public void addBeanConfig(IBeanConfig beanConfig) {
		String beanName = beanConfig.getBeanName();

		if (beanConfigs.containsKey(beanName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ beanName
					+ "', the old value is replaced by the specified IBeanConfig instance. Please see the configuration file zerocouplage.xml");
		}
		beanConfigs.put(beanConfig.getBeanName(), beanConfig);
	}

	@Override
	public void removeBeanConfig(String beanName) {
		beanConfigs.remove(beanName);
	}

	@Override
	public Map<String, IBeanConfig> getBeanConfigs() {
		return beanConfigs;
	}

	@Override
	public void setBeanConfigs(Map<String, IBeanConfig> beanConfigs) {
		this.beanConfigs = beanConfigs;
	}

}
