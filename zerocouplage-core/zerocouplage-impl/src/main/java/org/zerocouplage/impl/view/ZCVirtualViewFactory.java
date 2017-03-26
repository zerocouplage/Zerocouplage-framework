package org.zerocouplage.impl.view;

import org.zerocouplage.api.config.IVirtualViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCVirtualView;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;
/**
 * @author Nasseur Hinde vesion 1.2.0
 * 
 */
public class ZCVirtualViewFactory {

	public static IZCVirtualView getVirtualView(Object view) {
		IZCVirtualView virtualView = null;
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

		String context = zcConfig.getLoaderConfig().getContext();

		IVirtualViewConfig virtualViewConfig = zcConfig.getLoaderConfig()
				.getVirtualViewConfigMap()
				.getVirtualViewConfigByContext(context);
		
		String className = virtualViewConfig.getClassName();
		
		if ("web".equals(context)||"mobile".equals(context) ||"desktop".equals(context)) {
			virtualView = (IZCVirtualView) ReflectManager
				.creatInstanceByClassName(className);	
			virtualView.setViewInstance(view);
		}
	
			
			
		return virtualView;
	}

}
