package org.zerocouplage.component.api.config;

/**
 * <p>
 * The API of loader of ZCcomponent
 * </p>
 * 
 * @author Nadia ELRHOUL
 * 
 */

public interface ZCCompLoader {

	public void LoaderXML();

	/**
	 * <p>
	 * The component configuration
	 * </p>
	 * 
	 * @return ZCCompConfig
	 */

	public ZCCompConfig getConfig();

}

