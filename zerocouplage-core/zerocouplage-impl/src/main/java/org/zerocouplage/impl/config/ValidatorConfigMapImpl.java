/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.config.IValidatorConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * The collection of IValidatorConfig information declared in the Zerocouplage
 * configuration file, zerocouplage.xml.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class ValidatorConfigMapImpl implements IValidatorConfigMap {

	/**
	 * <p>
	 * The set of IValidatorConfig instance
	 * </p>
	 */
	private Map<String, IValidatorConfig> validatorConfigs;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ValidatorConfigMapImpl.class);

	/**
	 * <p>
	 * Constructs ValidatorConfigMapImpl instance
	 * </p>
	 */
	public ValidatorConfigMapImpl() {
		super();
		this.validatorConfigs = new HashMap<String, IValidatorConfig>();
	}

	@Override
	public IValidatorConfig getValidatorConfigByName(String validatorName) {
		return ((IValidatorConfig) validatorConfigs.get(validatorName));
	}

	@Override
	public void addValidatorConfig(IValidatorConfig validatorConfig) {
		String validatorName = validatorConfig.getName();

		if (validatorConfigs.containsKey(validatorName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ validatorName
					+ "', the old value is replaced by the specified IValidatorConfig instance. Please see the configuration file zerocouplage.xml");
		}
		validatorConfigs.put(validatorConfig.getName(), validatorConfig);
	}

	@Override
	public void removeValidatorConfig(String validatorName) {
		validatorConfigs.remove(validatorName);
	}

	@Override
	public Map<String, IValidatorConfig> getValidatorConfigs() {
		return validatorConfigs;
	}

	@Override
	public void setValidatorConfigs(
			Map<String, IValidatorConfig> validatorConfigs) {
		this.validatorConfigs = validatorConfigs;
	}

}