/**
 * 
 */
package org.zerocouplage.api.config;

public interface IZeroCouplageConfig {
	
	/**
	 * loader Configuration From File Xml zerocouplage
	 */
	public void loadConfigFromXML();

	/**
	 * 
	 * @return
	 */
	public IZCLoaderConfig getLoaderConfig();

	/**
	 * 
	 * @param loader
	 */
	public void setLoaderConfig(IZCLoaderConfig loader);
	

}