/**
 * 
 */
package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zerocouplage.api.config.IMapBeanViewConfig;

/**
 * <p>The configuration information of a IMapBeanViewConfig element from the Zerocouplage configuration file. 
 * IMapBeanViewConfig represents the mapping between IBeanConfig (the configuration informationof a bean)
 * and IViewConfig (the configuration information of a view).</p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 * 
 */
public class MapBeanViewConfigImpl implements IMapBeanViewConfig {

	/**
	 * <p>The name of the mapping</p>
	 */
	private boolean same;

	/**
	 * <p>The view name associated with this mapping</p>
	 */
	private String viewName;

	/**
	 * <p>The bean name associated with this mapping</p>
	 */
	private String beanName;
	
	/**
	 * <p>The format of date in the view associated with this mapping</p>
	 */
	private Map<String, String> viewFomats;

	/**
	 * <p>The Map of properties</p>
	 */
	private Map<String, String> mappingProperties;

	/**
	 * <p>Constructor for MapBeanViewConfigImpl</p>
	 */
	public MapBeanViewConfigImpl() {
		super();
		this.same = false;
		this.viewName = "";
		this.beanName = "";
		this.mappingProperties = new HashMap<String, String>();
		this.viewFomats = new HashMap<String, String>();
	}

	@Override
	public String getId() {
		return getBeanName() + "$:$" + getViewName();
	}

	@Override
	public boolean isSame() {
		return this.same;
	}

	@Override
	public void setSame(boolean same) {

		this.same = same;
	}

	@Override
	public String getViewName() {
		return this.viewName;
	}

	@Override
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public String getBeanName() {
		return this.beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public void setBeanViewProperty(String beanProperty, String viewProperty) {
		mappingProperties.put(beanProperty, viewProperty);
	}

	@Override
	public String getBeanProperty(String viewProperty) {
		return mappingProperties.get(viewProperty);/*****le view equibalent au bean dans le mapping*****/
	}

	@Override
	public String getViewProperty(String beanProperty) {
		return mappingProperties.get(beanProperty);/*****le bean equivalent au champ dans le mapping*****/
	}

	@Override
	public Map<String, String> getMappingProperties() {
		return mappingProperties;
	}

	@Override
	public void setMappingProperties(Map<String, String> properties) {
		this.mappingProperties = properties;
	}
	@Override
	public void setViewFormat(String viewProperty, String format) {
		if (format != null) {
			viewFomats.put(viewProperty, format);
		}
	}

	@Override
	public String getViewFormat(String viewProperty) {
		return viewFomats.get(viewProperty);
	}

	@Override
	public String getBeanFormat(String beanProperty) {
		String viewProperty = getViewProperty(beanProperty);
		return getViewFormat(viewProperty);
	}

	@Override
	public Map<String, String> getViewFormats() {
		return viewFomats;
	}

}
