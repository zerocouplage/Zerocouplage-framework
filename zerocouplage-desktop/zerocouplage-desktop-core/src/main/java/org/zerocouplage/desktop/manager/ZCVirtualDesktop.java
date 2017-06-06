package org.zerocouplage.desktop.manager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.desktop.page.ZCSharedPage;

import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCVirtualView;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.common.tools.StringTools;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;

/**
 * @author Mestari Salma version 1.2.0
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author HMIZA version 2.0.0
 */
public class ZCVirtualDesktop implements IZCVirtualView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String viewName;
	private Object viewInstance;
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCVirtualDesktop.class);
	@Override
	public Map<String, Object> getListParm() {
		Map<String, Object> listParams = new HashMap<String, Object>();

		Class viewC = this.viewInstance.getClass();

		Method[] viewMethodes = viewC.getDeclaredMethods();
		for (int i = 0; i < viewMethodes.length; i++) {
			String methodName = viewMethodes[i].getName();
			if (methodName.startsWith("get")) {
				listParams.put(StringTools.createFieldName(methodName),
						ReflectManager.executeMethode(this.viewInstance,
								methodName));
			}

		}
		return listParams;
	}

	@Override
	public String getViewName() {
		IViewConfig viewConfig = null;
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		if (this.viewInstance != null) {
			viewConfig = zcConfig
					.getLoaderConfig()
					.getViewConfigMap()
					.getViewConfigByClassName(
							this.viewInstance.getClass().getCanonicalName());
		}
		if (viewConfig != null) {
			viewName = viewConfig.getName();
		}
		return viewName;
	}

	public ZCVirtualDesktop() {
		super();
	}

	@Override
	public void goToPageError(String pageName,
			Map<String, String> listParamsError) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		IViewConfig viewConfig = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByClassName(pageName);
		Object instance = ReflectManager
				.creatInstanceByClassName(pageName);
			try {
				
				if (ReflectManager.getNbrOfParameter(instance,
						viewConfig.getMethodeErrorName()) == 2) {
					ReflectManager.executeMethode(instance,
							viewConfig.getMethodeErrorName(),
							this.getListParm(), listParamsError);
				} else if (ReflectManager.getNbrOfParameter(instance,
						viewConfig.getMethodeErrorName()) == 1) {
					ReflectManager.executeMethode(instance,
							viewConfig.getMethodeErrorName(), listParamsError);
				} else if (ReflectManager.getNbrOfParameter(instance,
						viewConfig.getMethodeErrorName()) == 0) {
					ReflectManager.executeMethode(instance,
							viewConfig.getMethodeErrorName());
				}
			} catch (ClassNotFoundException e) {
				logger.error("cannot find the classe that you are reffering to in zerocouplage.xml");
				e.printStackTrace();
			}
			Object page = ReflectManager.executeMethode(instance,
					viewConfig.getMethodeName());
			ZCPage currentPage = null;
			if (ZCPage.class.isInstance(page)) {
				currentPage = (ZCPage) page;
			} else {
				throw new RuntimeException(
						"problem while running a methode or a constructor");
			}

			try {
				ZCSharedPage.getINSTANCE().drawPage(currentPage);
			} catch (Exception e) {
				logger.error("cannot draw the current page ");
				e.printStackTrace();
			}
		}
	

	@Override
	public void setViewInstance(Object view) {
		this.viewInstance = view;
	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue,
			boolean useSameViewInstance) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

		IViewConfig resultView = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByName(pageName);
		String target = resultView.getTargetName();
		
		Object instanceView = null;
		if (useSameViewInstance) {
			instanceView = this.viewInstance;
		} else {
			instanceView = ReflectManager.creatInstanceByClassName(target);
		}

		// Passage des parametres au view pageName (instanceView)
		if (resultView.getBeanInName() != null && !resultView.getBeanInName().isEmpty()) {
			
			String setterBeanNameMethode = StringTools.createSetter(resultView.getBeanInName());
			ReflectManager.executeMethode(instanceView, setterBeanNameMethode, beanValue);
		}
		
		try {
			//TODO : faire la meme chose que mobile
			if (ReflectManager.getNbrOfParameter(instanceView,
					resultView.getMethodeName()) == 0) {

				
				Object page = ReflectManager.executeMethode(instanceView, resultView.getMethodeName());
				ZCPage currentPage = null;
				if (ZCPage.class.isInstance(page)) {
					currentPage = (ZCPage) page;
				} else {
					throw new RuntimeException(
							"problem while running a methode or a constructor");
				}

				try {
					ZCSharedPage.getINSTANCE().drawPage(currentPage);
				} catch (Exception e) {
					logger.error("cannot draw the current page ");
					e.printStackTrace();
				}

			} else {

				Object page = ReflectManager.executeMethodeByClassName(target,
						resultView.getMethodeName(), beanValue);
				ZCPage currentPage = null;
				if (ZCPage.class.isInstance(page)) {
					currentPage = (ZCPage) page;
				} else {
					throw new RuntimeException(
							"problem while running a methode or a constructor");
				}

				try {
					ZCSharedPage.getINSTANCE().drawPage(currentPage);
				} catch (Exception e) {
					
					e.printStackTrace();
				}

			}
		} catch (ClassNotFoundException e) {
			logger.error("cannot find the classe that you are reffering to in zerocouplage.xml");
			e.printStackTrace();
		}


	}

}
