package org.zerocouplage.api.config;

import java.util.Map;

/**
 * <p>
 * The collection of virtual views configuration information declared in the
 * Zerocouplage configuration file.
 * </p>
 * 
 */
public interface IVirtualViewConfigMap {

	/**
	 * <p>
	 * Returns the IVirtualViewConfig instance for the specified context
	 * </p>
	 * 
	 * @param context
	 *            the context by which the IVirtualViewConfig instance will be
	 *            retrieved
	 * @return the IVirtualViewConfig instance stored with the supplied context
	 */
	public IVirtualViewConfig getVirtualViewConfigByContext(String context);

	/**
	 * <p>
	 * Add a new virtual view configuration instance to the collection
	 * </p>
	 * 
	 * @param virtualView
	 *            IVirtualViewConfig instance to be added
	 */
	public void addVirtualViewConfig(IVirtualViewConfig virtualView);

	/**
	 * <p>
	 * Remove the IVirtualViewConfig instance for the specified context
	 * </p>
	 * 
	 * @param context
	 *            the context whose associated IVirtualViewConfig instance is to
	 *            be removed
	 */
	public void removeVirtualViewConfig(String context);

	/**
	 * <p>
	 * Returns a Map of IVirtualViewConfig instance
	 * </p>
	 * 
	 * @return a Map of IVirtualViewConfig instance
	 */
	public Map<String, IVirtualViewConfig> getVirtualViewConfigs();

	/**
	 * <p>
	 * Set the Map of virtual view configuration instance specified
	 * </p>
	 * 
	 * @param virtualViewConfigs
	 *            the Map of virtual view configuration instance
	 */
	public void setVirtualViewConfigs(
			Map<String, IVirtualViewConfig> virtualViewConfigs);

}
