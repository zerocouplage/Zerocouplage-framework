package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.ISecurityConfig;
import org.zerocouplage.api.config.ISecurityConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

public class SecurityConfigMapImpl implements ISecurityConfigMap {
	
	private Map<String, ISecurityConfig> securityConfigs;
	private boolean security;

	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(SecurityConfigMapImpl.class);

	public SecurityConfigMapImpl() {
		super();
		this.securityConfigs = new HashMap<String, ISecurityConfig>();
	}

	
	public ISecurityConfig getSecurityConfigByName(String securityName) {
		
		return ((ISecurityConfig) securityConfigs.get(securityName));
	}

	
	public void addSecurityConfig(ISecurityConfig securityConfig) {
		String securityName = securityConfig.getName();
		if (securityConfigs.containsKey(securityName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ securityName
					+ "', the old value is replaced by the specified ISecurityConfig instance. Please see the configuration file zerocouplage.xml");
		}
		securityConfigs.put(securityConfig.getName(), securityConfig);
		
	}

	
	public void removeSecurityConfig(String securityName) {
		securityConfigs.remove(securityName);
		
	}

	
	public Map<String, ISecurityConfig> getSecurityConfigs() {
		return securityConfigs;
	}

	
	public void setSecurityConfigs(Map<String, ISecurityConfig> securityConfigs) {
		this.securityConfigs = securityConfigs;
		
	}
	
	/* 
	 Fonction qui permet de vérifier si la sécurité totale est activée ou pas
	 */
	
	public boolean isSecurity() {
		return security;
	}

	public void setSecurity(boolean security) {
		this.security = security;
	}

}
