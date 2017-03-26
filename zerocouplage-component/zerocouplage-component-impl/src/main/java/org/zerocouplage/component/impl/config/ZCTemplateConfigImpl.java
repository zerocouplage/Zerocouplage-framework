package org.zerocouplage.component.impl.config;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.config.IZCTemplateConfig;

/**
 * 
 * @author Asmae ESSBAI
 * 
 */
public class ZCTemplateConfigImpl implements IZCTemplateConfig {

	private String content;
	private ZCComponent component;

	public ZCTemplateConfigImpl(String content, ZCComponent component) {
		this.content = content;
		this.component = component;

	}

	public ZCComponent getComponent() {
		return component;
	}

	public void setComponent(ZCComponent component) {
		this.component = component;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void replace(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

//	public void replace(String key, Object value) throws Exception {
//
//		if (value instanceof ZCComponent) {
//			String code = content.replaceAll("\\." + key + "\\.",
//					((ZCComponent) value).display().toString());
//			// System.out.println(content.replaceAll("\\." + key +
//			// "\\.",((ZCComponent) value).display().toString()));
//			setContent(code);
//			// System.out.println(content);
//		} else {
//			String code = content.replaceAll("\\." + key + "\\.",
//					value.toString());
//			// System.out.println(content.replaceAll("\\." + key + "\\.",
//			// value.toString()));
//			setContent(code);
//			// System.out.println(content);
//		}
//		// System.out.println(content);
//	}

}
