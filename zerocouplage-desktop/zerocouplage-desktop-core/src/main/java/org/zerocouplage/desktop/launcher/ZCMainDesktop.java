package org.zerocouplage.desktop.launcher;


import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;
import org.zerocouplage.impl.controller.ZCManagerFactory;

import com.sun.javafx.application.PlatformImpl;

public class ZCMainDesktop {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		ZCMainDesktop ViewVide = new ZCMainDesktop();
		//Initialization du JavaFx.
		PlatformImpl.startup(() -> {});
		IZCManager manager = ZCManagerFactory.getNewManager(ViewVide );
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		zcConfig.getLoaderConfig().setContext("desktop");
		
		manager.executeBusiness("index");

	}
}
