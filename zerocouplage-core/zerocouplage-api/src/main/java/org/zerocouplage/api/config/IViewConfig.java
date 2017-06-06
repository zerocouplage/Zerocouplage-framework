/**
 * 
 */
package org.zerocouplage.api.config;

/**
 * <p>
 * The configuration information of a view element from the Zerocouplage
 * configuration file, zecouplage.xml.
 * </p>
 * 
 */
public interface IViewConfig {

	/**
	 * <p>Returns a name for this IViewConfig</p>
	 * 
	 * @return the IViewConfig name
	 */
	public String getName();
	
	/**
	 * <p>Set a name for this IViewConfig</p>
	 * 
	 * @param name the IViewConfig name
	 */
	public void setName(String name);

	/**
	 * <p>Returns the name of a target to which this IViewConfig is to be forwarded. This
	 * name is either a class name or a file depending on the context of the application : desktop based
	 * or web based.</p>
	 * 
	 * @return the name of a target to which this IViewConfig is to be forwarded
	 */
	public String getTargetName();
	
	/**
	 * <p>Set the name of a target to which this IViewConfig is to be forwarded.</p>
	 * 
	 * @param targetName the name of a target to which this IViewConfig is to be forwarded
	 */
	public void setTargetName(String targetName);

	/**
	 * <p>Returns the name of the IViewConfig method if the <code>getTargetName()</code> returns a class name.
	 * This returned method is executed to display the result page in desktop based application.</p>
	 * 
	 * @return the name of the IViewConfig method
	 */
	public String getMethodeName();
	
	/**
	 * <p>Set the name of the IViewConfig method.</p>
	 * 
	 * @param methodName the name of the IViewConfig method
	 */
	public void setMethodeName(String methodName);

	/**
	 * <p>Returns the name of the IViewConfig error method if the <code>getTargetName()</code> returns a class name.
	 * This returned method is executed to display the error page in desktop based application.</p>
	 * 
	 * @return the name of the IViewConfig error method
	 */
	public String getMethodeErrorName();

	/**
	 * <p>Set the name of the IViewConfig error method.</p>
	 * 
	 * @param methodeErrorName the name of the IViewConfig error method
	 */
	public void setMethodeErrorName(String methodeErrorName);
	
	public void setBeanInName(String beanInName);
	
	public String getBeanInName();
}