package org.zerocouplage.component.impl.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.config.IZCTemplateConfig;
import org.zerocouplage.component.api.config.IZCTemplateLoader;

import org.zerocouplage.common.reflect.ReflectManager;

/**
 * 
 * @author Asmae ESSBAI
 * 
 */
public class ZCTemplateLoaderImpl implements IZCTemplateLoader {

	private static ZCTemplateLoaderImpl instance;
	private IZCTemplateConfig templateConfig;
	private Class<?> cl;

	public ZCTemplateLoaderImpl(Class<?> cl) {
		this.cl = cl;
		load(cl);
	}

	public Class<?> getCl() {
		return cl;
	}

	public void setCl(Class<?> cl) {
		this.cl = cl;
	}

	public static ZCTemplateLoaderImpl getInstance(Class<?> cl) {
		if (instance == null) {
			instance = new ZCTemplateLoaderImpl(cl);
		}
		return instance;
	}

	public void load(Class<?> cl) {
		String tempateName = cl.getName();
		//String ac = cl.getPackage().getName();
		String path = tempateName.replaceAll("\\.", "/");
		//System.out.println(path);
		//System.out.println(ac);
		String content = "";
		BufferedReader buffer = null;

		InputStream templateStream;

		try {

			templateStream = cl.getClassLoader().getResourceAsStream(
					path + ".zct");
			buffer = new BufferedReader(new InputStreamReader(templateStream));
			while (buffer.ready() == true) {
				content += buffer.readLine();
			}
		} catch (NullPointerException a) {
			System.out
					.println("Error: pointer is null ,create the template in the same package in eclipse ");
		} catch (IOException a) {
			System.out.println("Problem of IO");
		}

		ZCComponent zccompo = (ZCComponent) ReflectManager
				.creatInstanceByClassName(tempateName);
		templateConfig = new ZCTemplateConfigImpl(content, zccompo);

	}

	public IZCTemplateConfig zcTemplateConfig() {
		return templateConfig;
	}

}
