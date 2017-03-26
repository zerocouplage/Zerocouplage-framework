package org.zerocouplage.component.api.config;

/**
 * 
 * @author Asmae ESSBAI
 * 
 */

public interface IZCTemplateLoader {

	/**
	 * <p>
	 * The method has the argument : current class
	 * 
	 * @param cl
	 */
	public void load(Class<?> cl);

	/**
	 * <p>
	 * </p>
	 * 
	 * @return templateConfig
	 */
	public IZCTemplateConfig zcTemplateConfig();

}

