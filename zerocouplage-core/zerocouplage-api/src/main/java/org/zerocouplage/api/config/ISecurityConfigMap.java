package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>The collection of ISecurityConfig information declared in the Zerocouplage
 * configuration file, zerocouplage.xml.</p>
 *
 */
public interface ISecurityConfigMap {
	/**
	 * <p>Returns the ISecurityConfig instance for the supplied securityName</p>
	 * 
	 * @param securityName the name by which the ISecurityConfig instance will be retrieved
	 * @return the ISecurityConfig instance stored with the supplied securityName
	 */
	public ISecurityConfig getSecurityConfigByName(String securityName);
	
	/**
	 * <p>Add a new Security configuration instance to the collection</p>
	 * 
	 * @param securityConfig ISecurityConfig instance to be added
	 */
	public void addSecurityConfig(ISecurityConfig securityConfig);
	
	/**
	 * <p>Removes the ISecurityConfig for the specified securityName</p>
	 * 
	 * @param securityName the name of Orbac security configuration instance to be removed
	 */
	public void removeSecurityConfig(String securityName);
	
	/**
	 * <p>Returns a Map of ISecurityConfig instance</p>
	 * 
	 * @return a Map of ISecurityConfig instance
	 */
	public Map<String, ISecurityConfig> getSecurityConfigs();
	
	/**
	 * <p>Set the Map of security configuration instance for this ISecurityConfigMap </p>
	 * 
	 * @param securityConfigs the Map of Security configuration instance
	 */
	public void setSecurityConfigs(Map<String, ISecurityConfig> securityConfigs);
	
	/**
	 * <p>Returns if the Orbac Security is Activated</p>
	 * @return Security set to Yes or No
	 */
	public boolean isSecurity();
	/**
	 * <p>Set the Security to Active mode or No</p>
	 * @param Security to true or false.
	 */
	public void setSecurity(boolean security);

}
