/**
 * 
 */
package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.IViewConfig;

/**
 * <p>
 * The configuration information of a view element from the Zerocouplage
 * configuration file, zecouplage.xml.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum
 *
 */
public class ViewConfigImpl implements IViewConfig{
	
	/**
	 * <p>The view name</p>
	 */
	protected String name;
	
	/**
	 * <p>The name of a view for web based application, or a Java class name 
	 * for desktop based application</p>
	 */
	protected String targetName;
	
	/**
	 * <p>The view method name for desktop based application</p>
	 */
	protected String methodeName;
	
	/**
	 * <p>The error view method name for desktop based application</p>
	 */
	protected String methodeErrorName;
	
	/**
	 * <p>Constructor for ViewConfigImpl</p>
	 */
	public ViewConfigImpl() {
		super();
	}

	@Override
	public String getName() 
	{
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTargetName() 
	{
		return this.targetName;
	}
	
	@Override
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	@Override
	public String getMethodeName() 
	{
		return this.methodeName;
	}
	
	@Override
	public void setMethodeName(String methodeName) {
		this.methodeName = methodeName;
	}

	@Override
	public String getMethodeErrorName() 
	{
		return this.methodeErrorName;
	}
	
	@Override
	public void setMethodeErrorName(String methodeErrorName) {
		this.methodeErrorName = methodeErrorName;
	}
	
}
