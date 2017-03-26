/**
 * 
 */
package org.zerocouplage.api.config;

/**
 * <p>The configuration information of a validator element from the zerocouplage.xml</p>
 *
 */
public interface IValidatorConfig {
	
	/**
	 * <p>Returns a name configured in zerocouplage.xml for this IValidatorConfig.</p>
	 * 
	 * @return IValidatorConfig name
	 */
	public String getName();
	
	/**
	 * <p>Set a name for this IValidatorConfig.</p>
	 * 
	 * @param name IValidatorConfig name
	 */
	public void setName(String name);

	/**
	 * <p>Returns a validator class name, or file name, whether the type of validator is a java class or an XML file.</p>
	 * 
	 * @return validator class name, or file name
	 */
	public String getValueTarget();

	/**
	 * <p>Set a validator class name, or file name, whether the type of validator is a Java class or an XML file.</p<
	 * 
	 * @param valueTarget validator class name, or file name
	 */
	public void setValueTarget(String valueTarget);

	/**
	 * <p>Indicates whether the validator is Java class or an XML file.</p>
	 * 
	 * @return
	 */
	public boolean isConfigFromFile();

	/**
	 * <p>Set whether the validator is Java class or an XML file.</p>
	 * 
	 * @param configFromFile
	 */
	public void setConfigFromFile(boolean configFromFile);
}