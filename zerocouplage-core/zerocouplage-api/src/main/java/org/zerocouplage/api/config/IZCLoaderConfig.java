package org.zerocouplage.api.config;

import java.util.Map;


/**
 * 
 * @author Diaw abdel aziz
 * 
 */

public interface IZCLoaderConfig {

	/**
	 * loader of Bean View mapping  package  parameters  to  Map object 
	 */
	public void loaderMapBeanViewConfigMap();

	/**
	 * loader  of   Beans package parameters to   Map object   
	 */
	public void loaderBeanConfigMap();

	/**
	 * loader of   Validators package parameters  to Map object
	 */
	public void loaderValidatorConfigMap();

	/**
	 * loader of   Business package  parameters   to  Map  object
	 */
	public void loaderBusinessConfigMap();

	/**
	 * loader of   View package  parameters  to Map object  
	 */
	public void loaderViewConfigMap();
	

	public void loaderVirtualViewConfigMap();

	/**
	 * 
	 * 
	 * @return  application development   context  
	 */
	public String getContext();

	/**
	 * 
	 * @param pContext
	 */
	public void setContext(String pContext); 
	
	/**
	 * 
	 * @return    application development mode 
	 * 
	 */
	public String getDevModes();

	/**
	 * 
	 * @return   Map object of mapping  Bean View Configuration 
	 * 
	 */
	public IMapBeanViewConfigMap getMapBeaViewConfigMap();

	/**
	 * 
	 * @return  Map object  of  Validator Configuration 
	 */
	public IValidatorConfigMap getValidatorConfigMap();

	/**
	 * 
	 * 
	 * @return  Map  object of  Business  Configuration
	 */
	public IBusinessConfigMap getBusinessConfigMap();

	/**
	 * 
	 * @return   Map object  of   View Configuration 
	 */
	public IViewConfigMap getViewConfigMap();

	/**
	 * 
	 * @return  Map object of Bean  Configuration 
	 */
	public IBeanConfigMap getBeanConfigMap();
	
	/**
	 * 
	 * @return   Map object  of  Virtual View Configuration 
	 */
	public IVirtualViewConfigMap getVirtualViewConfigMap();
	
	/**
	 * 
	 * @return  Map object of Bean View name 
	 */
	public Map<String,String> getBeanViewName();
	
	
	/**
	 * 
	 * 
	 * @return  application development   context  
	 */
	public String getAppName();


}
