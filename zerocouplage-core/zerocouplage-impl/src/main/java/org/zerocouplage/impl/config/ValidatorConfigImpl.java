/**
 * 
 */
package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.IValidatorConfig;

/**
 * <p>The configuration information of a validator element from the Zerocouplage 
 * configuration file, zerocouplage.xml</p>
 *
 *
 * @author Guelmbaye Djikoloum
 * 
 */
public class ValidatorConfigImpl implements IValidatorConfig {

	/**
	 * <p>The validator name</p>
	 */
	private String name;

	/**
	 * <p>An XML file name or a Java class name, depending on the type of validator</p>
	 */
	private String valueTarget;

	/**
	 * <p>Indicates whether the validator is based on an XML file or a Java class</p>
	 */
	private boolean configFromFile;

	/**
	 * <p>Constructor for ValidatorConfigImpl</p>
	 */
	public ValidatorConfigImpl() {
		super();
		this.name = "";
		this.valueTarget = "";
		this.configFromFile = true;
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
	public String getValueTarget() {
		return valueTarget;
	}

	@Override
	public void setValueTarget(String value) {
		this.valueTarget = value;
	}

	@Override
	public boolean isConfigFromFile() {
		return configFromFile;
	}

	@Override
	public void setConfigFromFile(boolean configFromFile) {
		this.configFromFile = configFromFile;
	}

}