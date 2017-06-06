package org.zerocouplage.impl.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import org.zerocouplage.api.config.IBeanConfig;
import org.zerocouplage.api.config.IBeanConfigMap;
import org.zerocouplage.api.config.IBusinessConfig;
import org.zerocouplage.api.config.IBusinessConfigMap;
import org.zerocouplage.api.config.IMapBeanViewConfig;
import org.zerocouplage.api.config.IMapBeanViewConfigMap;
import org.zerocouplage.api.config.IResultBusinessConfig;
import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.config.IValidatorConfigMap;
import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IViewConfigMap;
import org.zerocouplage.api.config.IVirtualViewConfig;
import org.zerocouplage.api.config.IVirtualViewConfigMap;
import org.zerocouplage.api.config.IZCLoaderConfig;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.constant.ZCTagLibs;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * 
 * @author root version 1.0.0
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author Belouchi Ahlam version 1.2.0
 * @author Bennadir Yasmine version 1.2.0
 * 
 */
public class ZCLoaderConfigImpl implements IZCLoaderConfig {

	private IMapBeanViewConfigMap mapBeaViewConfigMap;
	private IBeanConfigMap beanConfigMap;
	private IValidatorConfigMap validatorConfigMap;
	private IBusinessConfigMap businessConfigMap;
	private IViewConfigMap viewConfigMap;
	
	private IVirtualViewConfigMap virtualViewConfigMap;
	
    private Map<String,String> beanviewName=new HashMap<String,String>();	

	private String context;
	private String appName; 
	private String DevModes;
	private static Document document;
	private static Element ZCracine;

	private static IZCLogger logger = ZCLoggerFactory.getLogger(ZCLoaderConfigImpl.class);
	
	public ZCLoaderConfigImpl(String path) throws ZCExceptionConfig {
		SAXBuilder sxb=new SAXBuilder();
		InputStream path_Zerocouplage;
		try {
			
			
			path_Zerocouplage = this.getClass().getClassLoader().getResourceAsStream(path);
			if (path_Zerocouplage==null) {
				throw new ZCExceptionConfig();
				}
					
			 document = sxb.build(path_Zerocouplage);
		}

		catch (ZCExceptionConfig e) {
			
			logger.error("please verify that the file zerocouplage.xml exists in the package ressources of your project");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (JDOMException e) {
         e.printStackTrace();		
        }

		ZCracine = document.getRootElement();
		context = ZCracine.getAttributeValue(ZCTagLibs.context);
		appName = ZCracine.getAttributeValue(ZCTagLibs.appName);
		DevModes = ZCracine.getAttributeValue(ZCTagLibs.DevModes);
	};

	/**
	 * @param args
	 */

	@Override
	public void loaderMapBeanViewConfigMap() {
		IMapBeanViewConfig mapBeanviewConfig = null;
		Boolean isSameViewBean;
		if (mapBeaViewConfigMap == null
				|| mapBeaViewConfigMap.getMapBeanViewConfigs().size() == 0) {

			mapBeaViewConfigMap = new MapBeanViewConfigMapImpl();

			Element mapBeanViewPackage = ZCracine.getChild(ZCTagLibs.mapBeanViewPackage);

			List<Element> listmapping = mapBeanViewPackage.getChildren();

			Iterator<Element> itermapping = listmapping.iterator();

			while (itermapping.hasNext()) {
				mapBeanviewConfig = new MapBeanViewConfigImpl();
				Element mapping = (Element) itermapping.next();
				mapBeanviewConfig.setBeanName(mapping
						.getAttributeValue(ZCTagLibs.refBean));
				mapBeanviewConfig.setViewName(mapping
						.getAttributeValue(ZCTagLibs.refView));
				beanviewName.put(mapping.getAttributeValue(ZCTagLibs.refBean), mapping.getAttributeValue(ZCTagLibs.refView));
				isSameViewBean=("false").equals(mapping.getAttributeValue(ZCTagLibs.isSame));

					mapBeanviewConfig.setSame(!isSameViewBean);
				

				List<Element> listKey = mapping.getChildren();
				Iterator<Element> iterKey = listKey.iterator();

				while (iterKey.hasNext()) {

					Element keyProperty = (Element) iterKey.next();

					mapBeanviewConfig.setBeanViewProperty(
							keyProperty.getAttributeValue(ZCTagLibs.beanProperty),
							keyProperty.getAttributeValue(ZCTagLibs.viewProperty));
					mapBeanviewConfig.setViewFormat(
							keyProperty.getAttributeValue(ZCTagLibs.viewProperty),
							keyProperty.getAttributeValue(ZCTagLibs.format));

				}
				mapBeaViewConfigMap.addMapBeanViewConfig(mapBeanviewConfig);
			}

			
		}

	}

	@Override
	public void loaderBeanConfigMap() {

		if (beanConfigMap == null || beanConfigMap.getBeanConfigs().size() == 0)

		{
			beanConfigMap = new BeanConfigMapImpl();

			Element beanPackage = ZCracine.getChild(ZCTagLibs.beansPackage);

			List<Element> listbeans = beanPackage.getChildren();

			Iterator<Element> iter = listbeans.iterator();

			while (iter.hasNext()) {
				IBeanConfig beanConfig = new BeanConfigImpl();
				Element bean = (Element) iter.next();
				beanConfig.setBeanName(bean.getAttributeValue(ZCTagLibs.name));
				beanConfig.setClassName(bean.getAttributeValue(ZCTagLibs.Class));

				beanConfigMap.addBeanConfig(beanConfig);

			}

		}
	}

	@Override
	public void loaderValidatorConfigMap() {
		if (validatorConfigMap == null
				|| validatorConfigMap.getValidatorConfigs().size() == 0) {
			validatorConfigMap = new ValidatorConfigMapImpl();
			Element validatorsPackage = ZCracine.getChild(ZCTagLibs.validatorsPackage);

			List<Element> listvalidators = validatorsPackage.getChildren();

			Iterator<Element> iter = listvalidators.iterator();

			while (iter.hasNext()) {

				IValidatorConfig validatorConfig = new ValidatorConfigImpl();
				Element validator = (Element) iter.next();

				validatorConfig.setName(validator.getAttributeValue(ZCTagLibs.name));
				if (validator.getAttributeValue(ZCTagLibs.typeVal).equals(ZCTagLibs.file))
					validatorConfig.setConfigFromFile(true);
				else
					validatorConfig.setConfigFromFile(false);

				try {

					if (validator.getAttributeValue(ZCTagLibs.typeVal).equals(ZCTagLibs.file)) {

						validatorConfig.setValueTarget(validator
								.getAttributeValue(ZCTagLibs.valueTarget));
					} else {
						validatorConfig.setValueTarget(validator
								.getAttributeValue(ZCTagLibs.valueTarget));

					}

				} catch (Exception e) {
				}
				validatorConfigMap.addValidatorConfig(validatorConfig);
			}

		}
	}

	
	public Map<String, IValidatorConfig> loadConfigBusiness(Element viewresult)
	{
		IBusinessConfig businessConfig = new BusinessConfigImpl();

		Map<String, IValidatorConfig> mapValidators = new HashMap<String, IValidatorConfig>();
		
		businessConfig
		.setValidatorConfig(validatorConfigMap
				.getValidatorConfigByName(viewresult
						.getAttributeValue(ZCTagLibs.refVal)));


		mapValidators.put(viewresult.getAttributeValue(ZCTagLibs.refVal),
		businessConfig.getValidatorConfig());

		return mapValidators;
	}
	
	@Override
	public void loaderBusinessConfigMap() {

		if (businessConfigMap == null
				|| businessConfigMap.getBusinessConfigs().size() == 0) {
			businessConfigMap = new BusinessConfigMapImpl();
			Element businessPackage = ZCracine.getChild(ZCTagLibs.businessPackage);

			List<Element> listbusiness = businessPackage.getChildren();

			Iterator<Element> iter = listbusiness.iterator();

			while (iter.hasNext()) {
				IBusinessConfig businessConfig = new BusinessConfigImpl();
				Element business = (Element) iter.next();

				businessConfig.setName(business.getAttributeValue(ZCTagLibs.name));
				businessConfig
						.setClassName(business.getAttributeValue(ZCTagLibs.Class));
				businessConfig.setMethodeName(business
						.getAttributeValue(ZCTagLibs.method));
				businessConfig.setPageError(business
						.getAttributeValue(ZCTagLibs.pageError));
				
				List<Element> listElement = business.getChildren();
				Iterator<Element> iterElement = listElement.iterator();

				while (iterElement.hasNext()) {
					Element courant = (Element) iterElement.next();

					if (courant.getName().equals(ZCTagLibs.beanRef)) {

						businessConfig.setInBeanConfig(beanConfigMap
								.getBeanConfigByName(courant
										.getAttributeValue(ZCTagLibs.refBean)));

					}

					if (courant.getName().equals(ZCTagLibs.validatorsRefs)) {

						List<Element> listValRef = courant.getChildren();

						Iterator<Element> itervieww = listValRef.iterator();

						Map<String, IValidatorConfig> validatorConfig = new HashMap<String, IValidatorConfig>();
						
						while (itervieww.hasNext()) {

							Element viewresult = (Element) itervieww.next();
						
							businessConfig
									.setValidatorConfig(validatorConfigMap
											.getValidatorConfigByName(viewresult
												.getAttributeValue(ZCTagLibs.refVal)));

						validatorConfig.put(viewresult.getAttributeValue(ZCTagLibs.refVal),
									businessConfig.getValidatorConfig());
						businessConfig.getValidatorConfig();
							


						}

						businessConfig.setValidatorConfigs(validatorConfig);

					}

					if (courant.getName().equals(ZCTagLibs.viewResults)) {

						List<Element> listviewResut = courant.getChildren();
						Iterator<Element> iterview = listviewResut.iterator();

						while (iterview.hasNext()) {
							IResultBusinessConfig resultBusiness = new ResultBusinessConfigImpl();
							Element viewresult = (Element) iterview.next();
							resultBusiness.setName(viewresult
									.getAttributeValue(ZCTagLibs.name));
							resultBusiness.setBeanName(viewresult
									.getAttributeValue(ZCTagLibs.beanResult));
							resultBusiness.setViewConfig(viewConfigMap
									.getViewConfigByName(viewresult
											.getAttributeValue(ZCTagLibs.refView)));
							businessConfig
									.addResultBusinessConfig(resultBusiness);

						}

					}
				}

				businessConfigMap.addBusinessConfig(businessConfig);

			}

		}
	}

	@Override
	public void loaderViewConfigMap() {

		if (viewConfigMap == null || viewConfigMap.getViewConfigs().size() == 0) {
			viewConfigMap = new ViewConfigMapImpl();
			Element viewPackage = ZCracine.getChild(ZCTagLibs.viewsPackage);

			List<Element> listviews = viewPackage.getChildren();

			Iterator<Element> iter = listviews.iterator();

			while (iter.hasNext()) {
				IViewConfig viewConfig = new ViewConfigImpl();
				Element view = (Element) iter.next();
				viewConfig.setName(view.getAttributeValue(ZCTagLibs.name));
				viewConfig.setTargetName(view.getAttributeValue(ZCTagLibs.target));
				viewConfig.setMethodeName(view.getAttributeValue(ZCTagLibs.method));
				viewConfig.setMethodeErrorName(view
						.getAttributeValue(ZCTagLibs.methodError));
				
				viewConfig.setBeanInName(view
						.getAttributeValue(ZCTagLibs.beanIn));
				
				
				
				viewConfigMap.addViewConfig(viewConfig);

			}

		}

	}
	
	
	
	public void loaderVirtualViewConfigMap(){
		
		if (virtualViewConfigMap == null
				|| virtualViewConfigMap.getVirtualViewConfigs().size() == 0) {
			
			virtualViewConfigMap = new VirtualViewConfigMapImpl();
			if(ZCracine.getChild(ZCTagLibs.virtualViewsPackage)!=null){
			
			Element virtualViewPackage = ZCracine.getChild(ZCTagLibs.virtualViewsPackage);

			List<Element> listVirtualView = virtualViewPackage.getChildren();

			Iterator<Element> iter = listVirtualView.iterator();

			while (iter.hasNext()) {
				IVirtualViewConfig virtualViewConfig = new VirtualViewConfigImpl();
				
				Element virtualView = (Element) iter.next();

				virtualViewConfig.setContext(virtualView.getAttributeValue(ZCTagLibs.context));
				virtualViewConfig
						.setClassName(virtualView.getAttributeValue(ZCTagLibs.Class));
				virtualViewConfigMap.addVirtualViewConfig(virtualViewConfig);

			}

		}
		}
	}

	

	

	

	public String getDevModes() {
		return DevModes;
	}

	public String getContext() {
		return context;
	}
	
	public void setContext(String pContext) {
		 context = pContext;
	}

	public IBeanConfigMap getBeanConfigMap() {
		return beanConfigMap;
	}

	public IViewConfigMap getViewConfigMap() {
		return viewConfigMap;
	}

	public IBusinessConfigMap getBusinessConfigMap() {
		return businessConfigMap;

	}

	public IValidatorConfigMap getValidatorConfigMap() {
		return validatorConfigMap;
	}

	public IMapBeanViewConfigMap getMapBeaViewConfigMap() {
		return mapBeaViewConfigMap;
	}
	

	public IVirtualViewConfigMap getVirtualViewConfigMap() {
		return virtualViewConfigMap;
	}

	@Override
	public Map<String, String> getBeanViewName() {
		return beanviewName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	
}