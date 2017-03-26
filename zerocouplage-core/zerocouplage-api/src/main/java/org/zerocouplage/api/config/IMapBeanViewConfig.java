/**
 * 
 */
package org.zerocouplage.api.config;

import java.util.List;
import java.util.Map;

/**
 * <p>The configuration information of a IMapBeanViewConfig element from the Zerocouplage configuration file. 
 * IMapBeanViewConfig represents the mapping between IBeanConfig (the configuration informationof a bean)
 * and IViewConfig (the configuration information of a view).</p>
 *
 */
public interface IMapBeanViewConfig {

	/**
	 * <p>Returns the id used to identify this IMapBeanViewConfig, only for development purpose.
	 * the value of this id is the concatenation of the IBeanConfig name and associated IViewConfig name.
	 * The separator used is <code>$:$</code> like in this example : <code>beanName$:$viewName</code></p>
	 * 
	 * @return the id of this IMapBeanViewConfig
	 */
	public String getId();

	/**
	 * <p>Indicate whether both IBeanConfig properties and IViewConfig properties have the same or not.</p>
	 * 
	 * @return 
	 */
	public boolean isSame();

	/**
	 * <p>Set whether both IBeanConfig properties and IViewConfig properties have the same or not.</p>
	 * 
	 * @param Same
	 */
	public void setSame(boolean same);

	/**
	 * <p>Returns a IViewConfig name associated with this IMapBeanViewConfig.</p>
	 * 
	 * @return the IViewConfig name for this IMapBeanViewConfig
	 */
	public String getViewName();

	/**
	 * <p>Set a name for the IViewConfig associated with this IMapBeanViewConfig.</p>
	 * 
	 * @param viewName the IViewConfig name 
	 */
	public void setViewName(String viewName);

	/**
	 * <p>Returns a IBeanConfig name associated with this IMapBeanViewConfig.</p>
	 * 
	 * @return the IBeanConfig name for this IMapBeanViewConfig
	 */
	public String getBeanName();

	/**
	 * <p>Set a name for the IBeanConfig associated with this IMapBeanViewConfig.</p>
	 * 
	 * @param beanName the IBeanConfig name
	 */
	public void setBeanName(String beanName);

	/**
	 * <p>Set both IBeanConfig and IViewConfig properties name.</p>
	 * 
	 * @param beanProperty the IBeanConfig property name
	 * @param viewProperty the IViewConfig property name
	 */
	public void setBeanViewProperty(String beanProperty, String viewProperty);

	/**
	 * <p>Returns the IBeanConfig property name for the specified IViewConfig property name.</p>
	 * 
	 * @param viewProperty the IViewConfig property name
	 * @return the IBeanConfig property name
	 */
	public String getBeanProperty(String viewProperty);
	
	/**
	 * <p>Returns the IBeanConfig property name for the specified IViewConfig property name.</p>
	 * 
	 * @param beanProperty the IBeanConfig property name
	 * @return the IViewConfig property name
	 */
	public String getViewProperty(String beanProperty);

	/**
	 * <p>Returns a Map of properties for this IMapBeanViewConfig
	 * 
	 * @return a Map of properties
	 */
	public Map<String, String> getMappingProperties();

	/**
	 * <p>Set a Map of properties for this IMapBeanViewConfig.</p>
	 * 
	 * @param properties Map of properties
	 */
	public void setMappingProperties(Map<String, String> properties);
	/**
	 * <p>Set a Map of format.</p>
	 * 
	 * @param viewProperty
	 * @param viewFormat
	 */
	public void setViewFormat(String viewProperty,String viewFormat);
	
	/**
	 * <p>Get the format form the view.</p>
	 * 
	 * @param viewProperty
	 */
	public String getViewFormat(String viewProperty);
	
	/**
	 * <p>Get format from bean.</p>
	 * 
	 * @param beanProperty
	 */
	public String getBeanFormat(String beanProperty);
	
	/**
	 * <p>Get a Map of format from view.</p>
	 * 
	 * 
	 */
	public Map<String, String> getViewFormats();


	
}
