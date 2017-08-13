package org.zerocouplage.impl.config;

import java.io.InputStream;

import org.zerocouplage.api.config.IZCLoaderConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.common.constant.ZCTagLibs;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;

public class ZeroCouplageConfigImpl implements IZeroCouplageConfig {
	private static ZeroCouplageConfigImpl INSTANCE;
	private IZCLoaderConfig loaderConfig;

	private ZeroCouplageConfigImpl() {
		String path = ZCTagLibs.ZCPath;
		try {
			loaderConfig = new ZCLoaderConfigImpl(path);
		} catch (ZCExceptionConfig e) {
			e.printStackTrace();
		}
		this.loadConfigFromXML();
	}

	public ZeroCouplageConfigImpl(InputStream streamZCxml) {

		try {
			loaderConfig = new ZCLoaderConfigImpl(streamZCxml);
		} catch (ZCExceptionConfig e) {
			e.printStackTrace();
		}
		this.loadConfigFromXML();
	}

	public static IZeroCouplageConfig getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ZeroCouplageConfigImpl();
		}
		return INSTANCE;
	}

	public static IZeroCouplageConfig getInstance(InputStream streamZCxml) {
		if (INSTANCE == null) {
			INSTANCE = new ZeroCouplageConfigImpl(streamZCxml);
		}
		return INSTANCE;
	}

	@Override
	public void loadConfigFromXML() {

		loaderConfig.loaderMapBeanViewConfigMap();
		loaderConfig.loaderBeanConfigMap();
		loaderConfig.loaderValidatorConfigMap();
		loaderConfig.loaderViewConfigMap();
		loaderConfig.loaderBusinessConfigMap();
		loaderConfig.loaderVirtualViewConfigMap();

	}

	@Override
	public IZCLoaderConfig getLoaderConfig() {
		return loaderConfig;
	}

	@Override
	public void setLoaderConfig(IZCLoaderConfig loaderConfig) {
		this.loaderConfig = loaderConfig;
	}

}
