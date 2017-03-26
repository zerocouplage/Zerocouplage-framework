package org.zerocouplage.common.tools;

/**
 * the StringTools class contains the methods allows to concatenate the field
 * name with getters and setters
 * 
 * @author bobmed version 1.0.0
 * @author Sara Taj version 1.2.0
 * 
 * 
 */
public class StringTools {

	/**
	 * @param fieldName
	 *            the field name
	 * @return the getter of field name with the first letter capitalized
	 */
	public static String createGetter(String fieldName) {
		String getter = "get" + GetFormatedField(fieldName);
		return getter;
	}

	/**
	 * @param fieldName
	 * @return formatedField the field name with the first letter capitalized
	 */
	private static String GetFormatedField(String fieldName) {
		String formatedField = fieldName.substring(0, 1).toUpperCase();

		formatedField += fieldName.substring(1);
		return formatedField;
	}

	/**
	 * @param fieldName
	 * @return the setter of field name with the first letter capitalized
	 */
	public static String createSetter(String fieldName) {
		String setter = "set" + GetFormatedField(fieldName);
		return setter;
	}

	/**
	 * @param methodName 
	 * @return the field name of getter with the first letter in lowercase
	 * 
 	 */
	public static String createFieldName(String methodName) {

		String field = methodName.substring(3);
		String lower = field.substring(0, 1).toLowerCase();
		String fieldName = lower + field.substring(1);

		return fieldName;
	}
}