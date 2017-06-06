package org.zerocouplage.mobile.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCVirtualView;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.common.tools.StringTools;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;

import android.app.Activity;
import android.content.Intent;
import android.widget.LinearLayout;

/**
 * @author Nasseur Hinde vesion 1.2.0
 * 
 */
public class ZCVirtualMobile implements IZCVirtualView {
	String viewName;
	Intent intent;
	Object viewInstance;
	public static Activity mainActivity = new Activity();
	LinearLayout resultLayout;

	private static IZCLogger logger = ZCLoggerFactory.getLogger(ZCVirtualMobile.class);

	private Map<String, Object> listMobileParams;

	public ZCVirtualMobile() {
		listMobileParams = new HashMap<String, Object>();
	}

	private Map<String, Object> loadListParam() {

		Class viewC = viewInstance.getClass();

		Method[] viewMethodes = viewC.getDeclaredMethods();
		for (int i = 0; i < viewMethodes.length; i++) {
			String methodName = viewMethodes[i].getName();
			if (methodName.startsWith("get")) {
				listMobileParams.put(StringTools.createFieldName(methodName),
						ReflectManager.executeMethode(viewInstance, methodName));
			}

		}

		return listMobileParams;
	}

	@Override
	public Map<String, Object> getListParm() {

		return loadListParam();
	}

	@Override
	public void goToPageError(String pageName, Map<String, String> listParamsError) {

		IViewConfig viewApplicableConfig = null;
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		String className = viewInstance.getClass().getName();
		IViewConfig currentViewConfig = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByClassName(className);

		Object instanceView = null;
		if (currentViewConfig.getName() != null && currentViewConfig.getName().equals(pageName)) {
			instanceView = this.viewInstance;
			viewApplicableConfig = currentViewConfig;
		} else {
			viewApplicableConfig = zcConfig.getLoaderConfig().getViewConfigMap().getViewConfigByName(pageName);
			String target = viewApplicableConfig.getTargetName();
			instanceView = ReflectManager.creatInstanceByClassName(target);
		}

		ReflectManager.executeMethode(instanceView, viewApplicableConfig.getMethodeErrorName(), listParamsError);

		Object page = ReflectManager.executeMethode(instanceView, viewApplicableConfig.getMethodeName());
		ZCPage currentPage = null;
		if (ZCPage.class.isInstance(page)) {
			currentPage = (ZCPage) page;
		} else {
			throw new RuntimeException("problem while running a methode or a constructor");
		}

		try {
			ZCSharedMobilePage.getINSTANCE().drawPage(currentPage);
		} catch (Exception e) {
			logger.error("cannot draw the current page ");
			e.printStackTrace();
		}

	}

	@Override
	public String getViewName() {

		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		IViewConfig viewConfig = null;
		String className = viewInstance.getClass().getName();
		viewConfig = zcConfig.getLoaderConfig().getViewConfigMap().getViewConfigByClassName(className);
		viewName = viewConfig.getName();

		return viewName;
	}

	@Override
	public void setViewInstance(Object viewInstance) {
		this.viewInstance = viewInstance;
	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue, boolean useSameViewInstance) {

		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

		IViewConfig resultViewConfig = zcConfig.getLoaderConfig().getViewConfigMap().getViewConfigByName(pageName);
		String target = resultViewConfig.getTargetName();

		Object instanceView = null;
		if (useSameViewInstance) {
			instanceView = this.viewInstance;
		} else {
			instanceView = ReflectManager.creatInstanceByClassName(target);
		}

		// Passage des parametres au view pageName (instanceView)
		if (resultViewConfig.getBeanInName() != null && !resultViewConfig.getBeanInName().isEmpty()) {

			String setterBeanNameMethode = StringTools.createSetter(resultViewConfig.getBeanInName());
			ReflectManager.executeMethode(instanceView, setterBeanNameMethode, beanValue);
		}

		Object page = ReflectManager.executeMethode(instanceView, resultViewConfig.getMethodeName());
		ZCPage currentPage = null;
		if (ZCPage.class.isInstance(page)) {
			currentPage = (ZCPage) page;
		} else {
			throw new RuntimeException("problem while running a methode or a constructor");
		}

		try {
			ZCSharedMobilePage.getINSTANCE().drawPage(currentPage);
		} catch (Exception e) {
			logger.error("cannot draw the current page ");
			e.printStackTrace();
		}

	}

}

/*
 * 
 * public void goToPage(String pageName, String beanName, Object beanValue,
 * boolean useSameViewInstance) { IZeroCouplageConfig zcConfig =
 * ZeroCouplageConfigImpl.getInstance();
 * 
 * //IViewConfig resultLayout = zcConfig.getLoaderConfig().getViewConfigMap()//
 * what type ? layout ? //.getViewConfigByName(pageName);
 * //resultLayout.setName(pageName);
 * 
 * LinearLayout rsl = new LinearLayout(mainActivity);
 * 
 * 
 * 
 * 
 * mainActivity.setContentView(rsl);
 * 
 * }
 */
