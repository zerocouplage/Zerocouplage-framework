/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IMapBeanViewConfig;
import org.zerocouplage.api.config.IMapBeanViewConfigMap;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * A collection of IMapBeanViewConfig configuration information declared in the
 * Zerocouplage configuration file, zerocouplage.xml
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class MapBeanViewConfigMapImpl implements IMapBeanViewConfigMap {

	/**
	 * <p>
	 * The set of IMapBeanViewConfig instances
	 * </p>
	 */
	private Map<String, IMapBeanViewConfig> mapBeanViewConfigs;

	/**
	 * <p>
	 * IZCLogger instance
	 * </p>
	 */
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(MapBeanViewConfigMapImpl.class);

	/**
	 * <p>
	 * Constructor for MapBeanViewConfigMapImpl
	 * </p>
	 */
	protected MapBeanViewConfigMapImpl() {
		super();
		this.mapBeanViewConfigs = new HashMap<String, IMapBeanViewConfig>();
	}

	@Override
	public IMapBeanViewConfig getMapBeanViewConfig(String beanName,
			String viewName) {
		return ((IMapBeanViewConfig) mapBeanViewConfigs.get(beanName + "$:$"
				+ viewName));
	}
	
	public void addMapBeanViewConfig(IMapBeanViewConfig mapBeanViewConfig) {

		String mapBeanViewName = mapBeanViewConfig.getId();
		

		if (mapBeanViewConfigs.containsKey(mapBeanViewName)) {
			logger.warn("The map previously contained a mapping for the key : '"
					+ mapBeanViewName
					+ "', the old value is replaced by the specified IMapBeanViewConfig instance. Please see the configuration file zerocouplage.xml");
		}
		mapBeanViewConfigs.put(mapBeanViewConfig.getId(), mapBeanViewConfig);
	}
	@Override
	public void removeMapBeanViewConfig(String idMapBeanView) {
		mapBeanViewConfigs.remove(idMapBeanView);
	}

	@Override
	public Map<String, IMapBeanViewConfig> getMapBeanViewConfigs() {
		return this.mapBeanViewConfigs;
	}

	@Override
	public void setMapBeanViewConfigs(
			Map<String, IMapBeanViewConfig> mapBeanViewConfigs) {
		this.mapBeanViewConfigs = mapBeanViewConfigs;

	}
	

	

}
