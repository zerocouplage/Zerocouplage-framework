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
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;

import android.app.Activity;
import android.content.Intent;
/**
 * @author Nasseur Hinde vesion 1.2.0
 * 
 */
public class ZCVirtualMobile implements IZCVirtualView {
	String viewName;
	Intent intent;
	Object viewInstance;
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCVirtualMobile.class);

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
				listMobileParams
						.put(StringTools.createFieldName(methodName),
								ReflectManager.executeMethode(viewInstance,
										methodName));
			}

		}

		return listMobileParams;
	}

	@Override
	public Map<String, Object> getListParm() {

		return loadListParam();
	}

	@Override
	public void goToPageError(String pageName,
			Map<String, String> listParamsError) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		IViewConfig viewConfig = null;
		String className = viewInstance.getClass().getName();
		viewConfig = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByClassName(className);
		if (viewInstance.getClass().getName().equals(pageName)) {

			ReflectManager.executeMethode(viewInstance,
					viewConfig.getMethodeErrorName(), listParamsError);

		} else {
			Object viewResult = ReflectManager
					.creatInstanceByClassName(pageName);

			intent = new Intent(((Activity) viewInstance).getApplication(),
					viewResult.getClass());

			for (String errorField : listParamsError.keySet()) {
				intent.putExtra(errorField, listParamsError.get(errorField));
			}

			for (String Field : listMobileParams.keySet()) {
				intent.putExtra(Field,
						(Serializable) listMobileParams.get(Field));
			}

			((Activity) viewInstance).startActivity(intent);

		}

	}

	@Override
	public String getViewName() {

		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		IViewConfig viewConfig = null;
		String className = viewInstance.getClass().getName();
		viewConfig = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByClassName(className);
		viewName = viewConfig.getName();

		return viewName;
	}

	@Override
	public void setViewInstance(Object viewInstance) {
		this.viewInstance = viewInstance;
	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue,
			boolean useSameViewInstance) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

		IViewConfig resultView = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByName(pageName);
		String target = resultView.getTargetName();

		if (useSameViewInstance) {
			intent = new Intent(((Activity) viewInstance).getApplication(),
					viewInstance.getClass());
			if (beanValue != null) {
				intent.putExtra(beanName, (Serializable) beanValue);
			}

		} else {
			Object view = ReflectManager.creatInstanceByClassName(target);

			intent = new Intent(((Activity) viewInstance).getApplication(),
					view.getClass());
			if (beanValue != null) {
				intent.putExtra(beanName, (Serializable) beanValue);
			}
		}

		((Activity) viewInstance).startActivity(intent);

	}

}
