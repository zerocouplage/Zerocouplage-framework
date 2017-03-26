/**
 * 
 */
package org.zerocouplage.api.controller;


/**
 * <p>This interface provides methods to execute business logic for incoming request.</p>
 *
 */
public interface IZCManager {
	
	/**
	 * <p>Executes the business whose name is specified. 
	 * This businessis is the appropriate one for a specific request from the user.</p>
	 * 
	 * @param businessName the business name
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void executeBusiness(String businessName) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
	
	/**
	 * <p>Executes the business whose name is specified. 
	 * This businessis is the appropriate one for a specific request from the user.</p>
	 * 
	 * @param businessName the business name
	 * @param useSameViewInstance indicates whether to use the same view instance from the request to display the result page or not
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void executeBusiness(String businessName, boolean useSameViewInstance) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
    
	/**
	 * <p>Returns a view instance from which a request come from.</p>
	 * 
	 * @return a view instance
	 */
	public Object getViewInstance();
}
