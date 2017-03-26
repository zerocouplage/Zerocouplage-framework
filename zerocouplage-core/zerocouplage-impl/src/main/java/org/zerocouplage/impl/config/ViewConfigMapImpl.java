/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IViewConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * The collection of views configuration information declared in the
 * Zerocouplage configuration file.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class ViewConfigMapImpl implements IViewConfigMap {

	/**
	 * <p>
	 * The set of IViewConfig instances
	 * </p>
	 */
	private Map<String, IViewConfig> viewConfigs;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ViewConfigMapImpl.class);

	/**
	 * <p>
	 * Constructs ViewConfigMapImpl instance
	 * </p>
	 */
	public ViewConfigMapImpl() {
		super();
		this.viewConfigs = new HashMap<String, IViewConfig>();
	}

	@Override
	public IViewConfig getViewConfigByName(String viewName) {
		return ((IViewConfig) viewConfigs.get(viewName));
	}

	@Override
	public void addViewConfig(IViewConfig viewConfig) {
		String viewName = viewConfig.getName();

		if (viewConfigs.containsKey(viewName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ viewName
					+ "', the old value is replaced by the specified IViewConfig instance. Please see the configuration file zerocouplage.xml");
		}

		viewConfigs.put(viewName, viewConfig);
	}

	@Override
	public void removeViewConfig(String viewName) {
		viewConfigs.remove(viewName);
	}

	@Override
	public IViewConfig getViewConfigByClassName(String viewClassName) {

		IViewConfig iViewConfig = null;
		boolean hasViewConfig = false;
		for (String viewName : this.viewConfigs.keySet()) {

			iViewConfig = this.viewConfigs.get(viewName);
			if (iViewConfig.getTargetName().equals(viewClassName)) {
				hasViewConfig = true;
				break;
			}

		}
		if (!hasViewConfig) {
			iViewConfig = null;
			logger.error("No IViewConfig is founded for the class '"
					+ viewClassName
					+ "', please see the configuration file zerocouplage.xml ");
		}
		return iViewConfig;
	}

	@Override
	public Map<String, IViewConfig> getViewConfigs() {
		return viewConfigs;
	}

	@Override
	public void setViewConfigs(Map<String, IViewConfig> viewConfigs) {
		this.viewConfigs = viewConfigs;
	}

}