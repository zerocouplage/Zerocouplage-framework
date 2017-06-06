package org.zerocouplage.web.manager;

import java.io.PrintWriter;
import java.util.Map;

import org.zerocouplage.component.api.page.ZCPage;

import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.common.tools.StringTools;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;

/**
 * @author Mestari Salma version 1.2.0
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author hmiza 2.0.0
 */
public class ZCComponentVirtualWeb extends ZCManagerWeb {

	protected static final long serialVersionUID = 1L;
	protected String viewName;
	protected Object viewInstance;
	protected static IZCLogger logger = ZCLoggerFactory.getLogger(ZCComponentVirtualWeb.class);

	@Override
	public void goToPageError(String pageName, Map<String, String> listParamsError) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		IViewConfig viewConfig = zcConfig.getLoaderConfig().getViewConfigMap().getViewConfigByClassName(pageName);

		String target = viewConfig.getTargetName();

		Object instance = ReflectManager.creatInstanceByClassName(pageName);

		try {

			if (ReflectManager.getNbrOfParameter(instance, viewConfig.getMethodeErrorName()) == 2) {
				ReflectManager.executeMethode(instance, viewConfig.getMethodeErrorName(), this.getListParm(),
						listParamsError);
			} else if (ReflectManager.getNbrOfParameter(instance, viewConfig.getMethodeErrorName()) == 1) {
				ReflectManager.executeMethode(instance, viewConfig.getMethodeErrorName(), listParamsError);
			} else if (ReflectManager.getNbrOfParameter(instance, viewConfig.getMethodeErrorName()) == 0) {
				ReflectManager.executeMethode(instance, viewConfig.getMethodeErrorName());
			}
		} catch (ClassNotFoundException e) {
			logger.error("cannot find the classe that you are reffering to in zerocouplage.xml");
			e.printStackTrace();
		}
		Object page = ReflectManager.executeMethode(instance, viewConfig.getMethodeName());

		ZCPage currentPage = null;
		if (ZCPage.class.isInstance(page)) {
			currentPage = (ZCPage) page;
		} else {
			throw new RuntimeException("problem while running a methode or a constructor");
		}

		try {
			writeHTMLResponst(currentPage);
		} catch (Exception e) {
			logger.error("cannot write the current page ");
			e.printStackTrace();
		}

	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue, boolean useSameViewInstance) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

		IViewConfig resultView = zcConfig.getLoaderConfig().getViewConfigMap().getViewConfigByName(pageName);
		String target = resultView.getTargetName();

		Object instanceView = null;
		instanceView = ReflectManager.creatInstanceByClassName(target);

		// Passage des parametres au view pageName (instanceView)
		if (resultView.getBeanInName() != null && !resultView.getBeanInName().isEmpty()) {

			String setterBeanNameMethode = StringTools.createSetter(resultView.getBeanInName());
			ReflectManager.executeMethode(instanceView, setterBeanNameMethode, beanValue);
		}

		try {
			//TODO : faire la meme chose que mobile
			if (ReflectManager.getNbrOfParameter(instanceView, resultView.getMethodeName()) == 0) {

				Object page = ReflectManager.executeMethode(instanceView, resultView.getMethodeName());
				ZCPage currentPage = null;
				if (ZCPage.class.isInstance(page)) {
					currentPage = (ZCPage) page;
				} else {
					throw new RuntimeException("problem while running a methode or a constructor");
				}

				try {
					writeHTMLResponst(currentPage);
				} catch (Exception e) {
					logger.error("cannot write the current page ");
					e.printStackTrace();
				}

			} else {

				Object page = ReflectManager.executeMethode(instanceView, resultView.getMethodeName(), beanValue);
				ZCPage currentPage = null;
				if (ZCPage.class.isInstance(page)) {
					currentPage = (ZCPage) page;
				} else {
					throw new RuntimeException("problem while running a methode or a constructor");
				}

				try {

					writeHTMLResponst(currentPage);

				} catch (Exception e) {
					logger.error("cannot write the current page ");
					e.printStackTrace();
				}

			}
		} catch (ClassNotFoundException e) {
			logger.error("cannot find the classe that you are reffering to in zerocouplage.xml");
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * methode that write the a ZCPage and show it in to the browser
	 * </p>
	 * 
	 * @param currentPage
	 * @throws Exception
	 */
	private void writeHTMLResponst(ZCPage currentPage) throws Exception {

		PrintWriter out = this.response.getWriter();
		if (currentPage != null) {
			out.println(currentPage.display());
		} else {
			// TODO : Rederction vers page erreur avec message d'erreur
			out.println("Erreur page current revoir la configuration ZC");
		}

		out.close();

	}

	@Override
	public void setViewInstance(Object view) {
		this.viewInstance = view;
	}

}
