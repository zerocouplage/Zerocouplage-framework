package org.zerocouplage.validator.forms;

import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.common.reflect.ReflectManager;

/**
 * the ZCValidatorFactory class contains the method that allows recovering the
 * validator
 * 
 * @author bobmed
 * 
 */
public class ZCValidatorFactory {

	/**
	 * specify if the validation is done via a class java or via an xml file and
	 * gets the validator
	 * 
	 * @param iValidatorConfig
	 *            the validator configuration recover from zerocouplage
	 *            configuration xml file
	 * @return izcValidator the validator
	 */
	public static IZCValidator getValidator(IValidatorConfig iValidatorConfig) {
		IZCValidator izcValidator = null;
		if (iValidatorConfig != null && !iValidatorConfig.isConfigFromFile()) {
			String classNameValidator = iValidatorConfig.getValueTarget();
			izcValidator = (IZCValidator) ReflectManager
					.creatInstanceByClassName(classNameValidator);
		} else {
			izcValidator = new ZCValidatorImpl(iValidatorConfig);
		}

		return izcValidator;
	}

}
