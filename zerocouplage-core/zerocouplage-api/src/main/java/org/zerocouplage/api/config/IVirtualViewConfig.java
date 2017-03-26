package org.zerocouplage.api.config;

/**
 * <p>
 * The configuration information of a virtual view from the Zerocouplage
 * configuration file.
 * </p>
 * 
 */
public interface IVirtualViewConfig {

	/**
	 * <p>
	 * Returns the context of the platform used in the instantiation of the
	 * virtual view.
	 * </p>
	 * 
	 * @return String representing the context of the platform used in the
	 *         instantiation of the virtual view.
	 */
	public String getContext();

	/**
	 * <p>
	 * the context of the platform used in the instantiation of the virtual
	 * view.
	 * </p>
	 * 
	 * @param context
	 *            of the platform used in the instantiation of the virtual view.
	 */
	public void setContext(String context);

	/**
	 * <p>
	 * Returns the class name to be used when creating a virtual view instance.
	 * </p>
	 * 
	 * @return a String representing the class name to be used when creating a
	 *         virtual view instance.
	 */
	public String getClassName();

	/**
	 * <p>
	 * The class name to be used when creating a virtual view instance.
	 * </p>
	 * 
	 * @param className
	 *            class name to be used when creating a virtual view instance.
	 */
	public void setClassName(String className);

}