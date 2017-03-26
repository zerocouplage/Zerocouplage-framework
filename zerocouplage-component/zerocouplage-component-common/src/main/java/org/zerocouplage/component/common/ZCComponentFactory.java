package org.zerocouplage.component.common;

import java.io.IOException;

import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.config.ZCCompConfigImpl;
import org.zerocouplage.component.impl.config.ZCCompLoaderImpl;
import org.zerocouplage.common.constant.ZCTagLibs;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.impl.config.ZCLoaderConfigImpl;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;


/**
 * <p>
 * instantiate the loader of ZC and get the implement class by Java reflection
 * </p>
 * 
 * @author Nadia ELRHOUL
 * 
 */

public class ZCComponentFactory extends ZCCompConfigImpl {
	private static ZCCompLoaderImpl loader;

	public static ZCAbstractComponent newComponent(Class<?> classApi)throws IOException, ZCCompNotFoundException, ZCExceptionConfig {

		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		String context = zcConfig.getLoaderConfig().getContext();
		String fileXml = "ZCComponent" + context + ".xml";
		String file = fileXml;
		loader = new ZCCompLoaderImpl(file);
		String classApiName = classApi.getName();
		ZCCompConfigImpl zcconfig = (ZCCompConfigImpl) ZCCompLoaderImpl.getInstance().getConfig();
		String classImplName = zcconfig.getClassImpl(classApiName);
		ZCAbstractComponent zcComponentClass = (ZCAbstractComponent) ReflectManager.creatInstanceByClassName(classImplName);
		return zcComponentClass;

	}

	/**
	 * 
	 * @return loader , the loader of the xml ZCComponentX
	 *         (X=web|X=Desktop|X=mobile)
	 */
	public ZCCompLoaderImpl getLoaderConfig() {
		return loader;
	}

	@SuppressWarnings("static-access")
	public void setLoaderConfig(org.zerocouplage.component.api.config.ZCCompConfig loader) {

		this.loader = (ZCCompLoaderImpl) loader;
	}

}



