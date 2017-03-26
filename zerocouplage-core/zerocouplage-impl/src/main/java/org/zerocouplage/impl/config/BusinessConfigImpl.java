package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IBeanConfig;
import org.zerocouplage.api.config.IBusinessConfig;
import org.zerocouplage.api.config.IResultBusinessConfig;
import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * The configuration information of a business element from the Zerocouplage
 * configuration file.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class BusinessConfigImpl implements IBusinessConfig {

	/**
	 * <p>
	 * The business name
	 * </p>
	 */
	private String name;

	/**
	 * <p>
	 * The business class name
	 * </p>
	 */
	private String className;

	/**
	 * <p>
	 * The business method name
	 * </p>
	 */
	private String methodeName;
	/**
	 * <p>
	 * The page error name
	 * </p>
	 */
	private String pageError;

	/**
	 * <p>
	 * A bean configuration instance associated with this business
	 * </p>
	 */
	private IBeanConfig inBeanConfig;

	/**
	 * <p>
	 * A view configuration instance of page error associated with this business
	 * </p>
	 */
//	private IViewConfig viewErrorConfig;

	/**
	 * <p>
	 * A validator confguration instance associated with this business
	 * </p>
	 */
	private Map<String, IValidatorConfig> validatorConfig;


	private IValidatorConfig validatorConfigs;

	/**
	 * <p>
	 * The set of result business instance for this business
	 * </p>
	 */
	private Map<String, IResultBusinessConfig> resultBusinessConfigMap;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(BusinessConfigImpl.class);

	/**
	 * <p>
	 * Constructor for BusinessConfigImpl
	 * </p>
	 */
	public BusinessConfigImpl() {
		super();
		this.name = "";
		this.className = "";
		this.methodeName = "";
		this.inBeanConfig = new BeanConfigImpl();
//		this.viewErrorConfig = new ViewConfigImpl();
		this.validatorConfig = new HashMap<String, IValidatorConfig>();
		this.resultBusinessConfigMap = new HashMap<String, IResultBusinessConfig>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String getMethodeName() {
		return methodeName;
	}

	@Override
	public void setMethodeName(String methodeName) {
		this.methodeName = methodeName;
	}

	@Override
	public IBeanConfig getInBeanConfig() {
		return inBeanConfig;
	}

	@Override
	public void setInBeanConfig(IBeanConfig beanConfig) {

		this.inBeanConfig = beanConfig;
	}

	@Override
	public Map<String, IValidatorConfig> getValidatorConfigs() {
		return validatorConfig;
	}

	@Override
	public void setValidatorConfigs(
			Map<String, IValidatorConfig> validatorConfig) {
		this.validatorConfig = validatorConfig;
	}

	@Override
	public IValidatorConfig getValidatorConfig() {

		return validatorConfigs;
	}

	@Override
	public void setValidatorConfig(IValidatorConfig validatorConfig) {

		this.validatorConfigs = validatorConfig;

	}

	@Override
	public Map<String, IResultBusinessConfig> getResultBusinessConfig() {
		return resultBusinessConfigMap;
	}

	@Override
	public void addResultBusinessConfig(
			IResultBusinessConfig resultBusinessConfig) {

		String resultBusinessName = resultBusinessConfig.getName();

		if (resultBusinessConfigMap.containsKey(resultBusinessName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ resultBusinessName
					+ "', the old value is replaced by the specified IResultBusinessConfig instance. Please see the configuration file zerocouplage.xml");
		}
		resultBusinessConfigMap.put(resultBusinessConfig.getName(),
				resultBusinessConfig);
	}

	@Override
	public IResultBusinessConfig getResultBusinessConfigByName(
			String resultBusinessName) {
		return ((IResultBusinessConfig) resultBusinessConfigMap
				.get(resultBusinessName));
	}

	@Override
	public void removeResultBusinessConfigByName(String resultBusinessName) {
		resultBusinessConfigMap.remove(resultBusinessName);
	}

	@Override
	public String getPageError() {
		return this.pageError;
	}

	@Override
	public void setPageError(String pageError) {
		this.pageError = pageError;
	}

}