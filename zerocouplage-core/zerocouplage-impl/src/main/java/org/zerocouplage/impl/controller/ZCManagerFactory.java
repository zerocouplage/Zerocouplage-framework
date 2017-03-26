/**
 * 
 */
package org.zerocouplage.impl.controller;

import org.zerocouplage.api.controller.IZCManager;

/**
 * <p>A factory for creating IZCManager instances to handle incoming requests</p>
 * @see IZCManager
 *
 */
public class ZCManagerFactory 
{

	/**
	 * <p>Creates and returns a newly instansiated IZCManager to handle 
	 * the request coming from the specified view instance.</p>
	 * 
	 * @param viewInstance the view instance
	 * @return IZCManager instance
	 */
	public static IZCManager getNewManager(Object viewInstance) {
		IZCManager manager =  new ZCManagerImpl(viewInstance);
		return manager;
}
	
}
