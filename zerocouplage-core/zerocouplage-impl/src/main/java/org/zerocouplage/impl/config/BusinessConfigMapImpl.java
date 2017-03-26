/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IBusinessConfig;
import org.zerocouplage.api.config.IBusinessConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * The collection of business configuration information declared in the
 * Zerocouplage configuration file.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class BusinessConfigMapImpl implements IBusinessConfigMap {

	/**
	 * <p>
	 * The set of IBusinessConfig instances
	 * </p>
	 */
	protected Map<String, IBusinessConfig> businessConfigs;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(BusinessConfigMapImpl.class);

	/**
	 * <p>
	 * Constructor for BusinessConfigMapImpl
	 * </p>
	 */
	public BusinessConfigMapImpl() {
		super();
		this.businessConfigs = new HashMap<String, IBusinessConfig>();
	}

	@Override
	public IBusinessConfig getBusinessConfigByName(String businessName) {
		return ((IBusinessConfig) businessConfigs.get(businessName));
	}

	@Override
	public void addBusinessConfig(IBusinessConfig businessConfig) {
		String businessName = businessConfig.getName();

		if (businessConfigs.containsKey(businessName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ businessName
					+ "', the old value is replaced by the specified IBusinessConfig instance. Please see the configuration file zerocouplage.xml");
		}
		businessConfigs.put(businessConfig.getName(), businessConfig);
	}

	@Override
	public void removeBusinessConfig(String businessName) {
		businessConfigs.remove(businessName);
	}

	@Override
	public Map<String, IBusinessConfig> getBusinessConfigs() {
		return businessConfigs;
	}

	@Override
	public void setBusinessConfigs(Map<String, IBusinessConfig> businessConfigs) {
		this.businessConfigs = businessConfigs;
	}

}