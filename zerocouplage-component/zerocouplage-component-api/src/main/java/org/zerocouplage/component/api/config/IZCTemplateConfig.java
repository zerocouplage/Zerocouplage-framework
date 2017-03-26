package org.zerocouplage.component.api.config;

/**
 * 
 * @author  Asmae ESSBAI
 *
 */
public interface IZCTemplateConfig {
	/**
	 * 
	 * @return content ......
	 */
	
	public Object getContent();
	/**
	 * 
	 * @param key
	 * @param value
	 */
	 public void replace(String key,Object value);

		
}