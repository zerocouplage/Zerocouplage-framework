package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.IVirtualViewConfig;
/**
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 *  
 */
public class VirtualViewConfigImpl implements IVirtualViewConfig {

	/**
	 * <p>
	 * The context of the platform used in the instantiation of the virtual
	 * view.
	 * </p>
	 * 
	 */
	private String context;

	/**
	 * <p>
	 * The class name of the virtual view associated with the context
	 * </p>
	 * 
	 */
	private String className;

	@Override
	public String getContext() {
		return this.context;
	}

	@Override
	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String getClassName() {
		return this.className;
	}

	@Override
	public void setClassName(String className) {
		this.className = className;
	}

}
