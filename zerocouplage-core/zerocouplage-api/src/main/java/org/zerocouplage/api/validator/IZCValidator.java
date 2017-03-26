/**
 * 
 */
package org.zerocouplage.api.validator;

import java.util.Map;

/**
 * 
 * 
 *
 */

import java.util.Map;

import org.zerocouplage.api.config.IMapBeanViewConfig;

/**
 * @author bobmed the IZCValidator interface defines the methods to be
 *         implemented by ZCValidator. Which are used by the Zerocouplage
 *         framework to validate forms fields before executing the Action.
 */
public interface IZCValidator {

	/**
	 * the method validate serve to validate the bean associated to form fields
	 * 
	 * @param bean
	 *            the bean to validate
	 * @return the error list after the validation
	 */
	public Map<String, String> validate(Map<Object, Object> viewValue,Map<String, String> propertiesMap,Object BeanIn);

}
