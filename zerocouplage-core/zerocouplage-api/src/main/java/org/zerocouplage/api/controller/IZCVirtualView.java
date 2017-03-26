/**
 * 
 */
package org.zerocouplage.api.controller;

import java.util.Map;

/**
 * IZCVirtualView interface  is used to represent the views of a virtual way
 * 
 * @author Abdel aziz version 1.0.0
 * @author Hinde Nasseur version 1.2.0
 *
 */
/**
 * <p>
 * This interface represents any view in a desktop based application, web based
 * application, or other. Zerocouplage all implementations other than desktop,
 * must implement this interface : web, mobile...
 * </p>
 */
public interface IZCVirtualView {
	/**
	 * this method allows to get list of parameters
	 * 
	 * @return list of view parameters
	 */

	public Map<String, Object> getListParm();

	/**
	 * <p>
	 * Returns a view name
	 * </p>
	 * 
	 * @return the view name
	 */
	public String getViewName();

	/**
	 * <p>
	 * Forwards to an error page, whose name is specified, and the Map of errors
	 * messages
	 * </p>
	 * 
	 * @param pageName
	 *            the name of the error page
	 * @param listParamsError
	 *            a Map of errors messages
	 */


	public void goToPageError(String pageName,
			Map<String, String> listParamsError);


	/**
	 * this method allows to display page
	 * 
	 * @param pageName
	 *            the page name to display
	 * @param beanName
	 *            the bean name
	 * @param beanValue
	 *            the bean object
	 */

	public void goToPage(String pageName, String beanName, Object beanValue,
			boolean useSameViewInstance);

	/**
	 * <p>
	 * this method allows to switch the real instance to the virtual layer.
	 * <p>
	 * 
	 * @param view
	 *            the bean object
	 */

	public void setViewInstance(Object view);

}
