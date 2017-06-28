/**
 * 
 */
package org.zerocouplage.impl.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.zerocouplage.clientapi.bean.ZCCookies;
import org.zerocouplage.clientapi.bean.ZCRequest;
import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.clientapi.exceptions.ZCClientException;
import org.zerocouplage.clientapi.httpmanager.IZCHttpManager;
import org.zerocouplage.clientapi.httpmanager.ZCCookiesManager;
import org.zerocouplage.clientcore.manager.ZCHttpManager;

import org.zerocouplage.api.config.IBeanConfig;
import org.zerocouplage.api.config.IBusinessConfig;
import org.zerocouplage.api.config.IMapBeanViewConfig;
import org.zerocouplage.api.config.IResultBusinessConfig;
import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.controller.IZCVirtualView;
import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.common.tools.StringTools;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;
import org.zerocouplage.impl.view.ZCVirtualViewFactory;
import org.zerocouplage.validator.forms.ZCValidatorFactory;
import org.zerocouplage.validator.forms.ZCconversionUtils;

/**
 * <p>
 * ZCManagerImpl contains the request processing logic. ZCManagerImpl is the
 * Controller in the Model-View-Controller (MVC) design pattern for Zerocouplage
 * applications. The ZCManagerImpl selects and invokes the appropriate business
 * class to perform the requested business logic.
 * </p>
 * 
 * 
 * @author Guelmbaye Djikoloum version 1.0.0
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author Bennadir Yasmine version 1.2.0
 * @author Mestari Salma version 1.2.0
 * @author Bellouchi Ahlam version 1.2.0
 * 
 * 
 */

public class ZCManagerImpl implements IZCManager {

	/**
	 * <p>
	 * The view instance from which a user request comes from
	 * </p>
	 */
	private Object viewInstance;
	IZCVirtualView izcVirtualView;
	Object view;
	Map<String, String> viewFormats = new HashMap<String, String>();
	public Map<Object, Object> ViewValue = new HashMap<Object, Object>();
	Map<String, String> propertiesMap = new HashMap<String, String>();

	/**
	 * <p>
	 * Construct a ZCManagerImpl object according to the specified view object
	 * </p>
	 * 
	 * @param view
	 *            the view object
	 */
	public ZCManagerImpl(Object view) {
		this.viewInstance = view;
	}

	@Override
	public void executeBusiness(String businessName)
			throws ClassNotFoundException {
		executeBusiness(businessName, false, "");
	}

	
	@Override
	public void executeBusiness(String businessName, boolean useSameViewInstance, String zcSourceEventComponentId)
			throws ClassNotFoundException {

		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		String typeApplication = zcConfig.getLoaderConfig().getContext();
		boolean isNotClientServeur = true;
		String  urlServeur = null;
		if(!"web".equals(typeApplication))
		{
		    urlServeur = loadURLServeur();
			isNotClientServeur = (urlServeur == null);
		}
		
		IViewConfig viewConfig = null;

		IBusinessConfig businessConfig = zcConfig.getLoaderConfig()
				.getBusinessConfigMap().getBusinessConfigByName(businessName);

		if (IZCVirtualView.class.isInstance(this.viewInstance)) {
			izcVirtualView = (IZCVirtualView) this.viewInstance;
		} else {
			initialize();
		}

		Object businessInstance = null;

		if (isNotClientServeur && businessConfig.getClassName() != null) {
			businessInstance = this.getBusinessConfigInstance(businessConfig);
		}

		IBeanConfig inBeanConfig = businessConfig.getInBeanConfig();
		Object inBeanInstance = null;

		if (inBeanConfig.getBeanName() != null) {
			inBeanInstance = this.getBeanConfigInstance(inBeanConfig);
		}

		viewConfig = zcConfig.getLoaderConfig().getViewConfigMap()
				.getViewConfigByName(izcVirtualView.getViewName());

		if (viewConfig != null) {
			IMapBeanViewConfig mapBeanViewConfig = zcConfig
					.getLoaderConfig()
					.getMapBeaViewConfigMap()
					.getMapBeanViewConfig(inBeanConfig.getBeanName(),
							viewConfig.getName());
			if (mapBeanViewConfig != null) {
				viewFormats = mapBeanViewConfig.getViewFormats();

				propertiesMap = mapBeanViewConfig.getMappingProperties();

				if (mapBeanViewConfig.isSame() || propertiesMap.isEmpty()) {

					propertiesMap = getMapSameField(inBeanInstance.getClass());
				}
			}
		} else {
			if (inBeanInstance != null)
				propertiesMap = getMapSameField(inBeanInstance.getClass());
		}

		try {
			this.setBeanPropertiesFromVirtualView(inBeanInstance,
					izcVirtualView, propertiesMap);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Map<String, IValidatorConfig> validatorConfig = businessConfig
				.getValidatorConfigs();

		Map<String, String> listErrors = null;

		listErrors = this.validateBean(validatorConfig, inBeanInstance);

		if (!listErrors.isEmpty()) {
			String sourceView = viewConfig.getTargetName();
			String pageErrorName = businessConfig.getPageError();
			String pageError;
			if (pageErrorName != null || "".equals(pageErrorName)) {
				pageError = zcConfig.getLoaderConfig().getViewConfigMap()
						.getViewConfigByName(pageErrorName).getTargetName();
			} else {
				pageError = sourceView;
			}
			izcVirtualView.goToPageError(pageError, listErrors);
			return;
		}

		String result = null;
		
		
		
		if(isNotClientServeur)
		{
			
			
			
			if (businessInstance != null) {
				
				if(ReflectManager.hasMethod(businessInstance.getClass(), "setIdSourceEvent", String.class))
				{
					ReflectManager.executeMethode(
							businessInstance, "setIdSourceEvent",
							zcSourceEventComponentId);
				}
				if (ReflectManager.getNbrOfParameter(businessInstance,
						businessConfig.getMethodeName()) == 0) {
					result = (String) ReflectManager.executeMethode(
							businessInstance, businessConfig.getMethodeName());//invoquer le business name ,la méthode

				} else {
					result = (String) ReflectManager.executeMethode(
							businessInstance, businessConfig.getMethodeName(),
							inBeanInstance);
				}
				
			}
		}
		

		Map<String, IResultBusinessConfig> resultMap = businessConfig
				.getResultBusinessConfig();
		IResultBusinessConfig resultBusiness = null;

		if (result != null) {
			resultBusiness = resultMap.get(result);

		} else {
			for (String keyResultBusiness : resultMap.keySet()) {
				resultBusiness = resultMap.get(keyResultBusiness);
				break;
			}
		}

		String resultBeanName = resultBusiness.getBeanName();
		String resultGetterBeanName = null;
		if (resultBeanName != null) {
			resultGetterBeanName = StringTools.createGetter(resultBeanName);
		}
		
		Object outBeanInstance = null;
		//cas possible : web, mobile ou destop
		
		
		if(!isNotClientServeur)
		{
				IZCHttpManager zcHttpManager = new ZCHttpManager();
				String agent = "zc"+typeApplication;//zcDesktop or zcMobile 
				ZCRequest request = new ZCRequest();

				zcHttpManager.setURLApplication(urlServeur);//"http://localhost:8080/ZCAppsDemo/"
				ZCCookies cookies = ZCCookiesManager.getInstance(zcHttpManager.getURLApplication());//singleton pour l'instanciation des cookies dans chaque application
				zcHttpManager.setAgent(agent);//ZcHttpManager(zcDesktop)
				request.setBusinessName(businessName);//exemple request.setBusinessName(traitement)
				request.addParam("_ZC_SOURCE_VIEW_NAME", izcVirtualView.getViewName());
				//request.addParam("";Vue de départ)
				
				Map<String, Object> listParam = izcVirtualView.getListParm();
				//Map clé valeur
				
				for (Iterator iterator = listParam.keySet().iterator(); iterator.hasNext();)
				{
					String parmName = (String) iterator.next(); //Nom du paramètre
					Object parmObjectValue =  listParam.get(parmName);//Objet envoyé sois fichier,sois des paramètres String
					
					//test sur l'objet paramObjectValue:
					
					if(parmObjectValue instanceof File)
						//le cas d'envoi d'un Fichier
					{
						request.setFileUpload((File)parmObjectValue);//Ajout de l'objet File dans la requete
						request.setFileFieledName(parmName);//Ajout du nom du fichier dans la requete
					}
					else
					{//le cas d'envoi des input des formulaires
						String parmValue = (String) parmObjectValue;//value input form
						request.addParam(parmName, parmValue);//Ajout des nooms et input du form
					}
				}
				
				
				
				ZCResponse zcResponse = null;
				try {
					zcResponse = zcHttpManager.send(request);//Envoi de la requête par le zcHttp Manger et réception de la réponse ZCResponse
					
				} catch (ZCClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			   outBeanInstance = zcResponse.getContent();
		}
		
		
		if (isNotClientServeur && resultGetterBeanName != null) {
			outBeanInstance = ReflectManager.executeMethode(businessInstance,
					resultGetterBeanName);
		}
		
	
		IViewConfig resultView = resultBusiness.getViewConfig();

		String resultViewName = resultView.getName();
		izcVirtualView.goToPage(resultViewName, resultBeanName,
				outBeanInstance, useSameViewInstance);

	}

	private String loadURLServeur() {
		String urlServeur = null;
		Properties zcConfigServeirProp = new Properties();
		InputStream filePropAsStream = this.viewInstance.getClass()
				.getClassLoader().getResourceAsStream("zcConfigServeur.properties");

		if(filePropAsStream != null)
		{
			try {
				zcConfigServeirProp.load(filePropAsStream);

				urlServeur = zcConfigServeirProp.getProperty("zc.serveur.url");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

		return urlServeur;
	}

	/**
	 * <p>
	 * Populate the properties of the specified bean instance (inBeanInstance)
	 * from the IZCVirtualView instance, using the Map of properties.
	 * </p>
	 * 
	 * @param inBeanInstance
	 *            The bean instance being populated
	 * @param izcVirtualView
	 *            The IZCVirtualView instance we are processing
	 * @param propertiesMap
	 *            The Map of properties being used
	 * @throws ClassNotFoundException
	 */
	private void setBeanPropertiesFromVirtualView(Object inBeanInstance,
			IZCVirtualView izcVirtualView, Map<String, String> propertiesMap)
			throws ClassNotFoundException {
		ZCconversionUtils convertTypes = new ZCconversionUtils();
		Object convertResult = null;
		Class lisType = null;
		for (String beanProperty : propertiesMap.keySet()) {

			String viewProperty = propertiesMap.get(beanProperty);
			String beanSetterMethodName = StringTools
					.createSetter(beanProperty);
			Object viewPropertyValue = izcVirtualView.getListParm().get(
					viewProperty);
			String beanGetterMethodName = StringTools
					.createGetter(beanProperty);
			convertTypes.setFormat(viewFormats.get(viewProperty));

			if (inBeanInstance != null) {
				lisType = ReflectManager.returnTypeMethod(inBeanInstance
						.getClass().getCanonicalName(), beanGetterMethodName);
				if (viewPropertyValue != null && !"".equals(viewPropertyValue)) {
					if (lisType.isInterface()) {

						convertResult = convertTypes.CastTypeList(lisType,
								(String[]) viewPropertyValue);

						ViewValue.put(viewProperty,
								(String[]) viewPropertyValue);

					} else {

						convertResult = convertTypes.CastTypeForm(
								viewPropertyValue.toString(), lisType);

						ViewValue.put(viewProperty, (String) viewPropertyValue);

					}

					ReflectManager.executeMethode(inBeanInstance,
							beanSetterMethodName, convertResult);
				}
			}
		}

	}

	/**
	 * <p>
	 * Returns a business instance from the IBusinessConfig instance specified
	 * </p>
	 * 
	 * @param businessConfig
	 *            The IBusinessConfig instance
	 * @return
	 */
	public Object getBusinessConfigInstance(IBusinessConfig businessConfig) {
		Object businessInstance = ReflectManager
				.creatInstanceByClassName(businessConfig.getClassName());
		return businessInstance;
	}

	/**
	 * <p>
	 * Returns a bean instance from the IBeanConfig instance specified
	 * </p>
	 * 
	 * @param beanConfig
	 *            The IBeanConfig instance
	 * @return
	 */
	public Object getBeanConfigInstance(IBeanConfig beanConfig) {
		Object beanInstance = ReflectManager
				.creatInstanceByClassName(beanConfig.getClassName());
		return beanInstance;
	}

	/**
	 * <p>
	 * Returns a Map of errors after validating a bean instance using the
	 * specified IValidatorConfig instance
	 * </p>
	 * 
	 * @param validatorConfig
	 *            The IValidatorConfig instance
	 * @param beanInstance
	 *            The bean instance
	 * @return
	 */
	public Map<String, String> validateBean(
			Map<String, IValidatorConfig> validatorConfi, Object beanInstance)
			throws ClassNotFoundException {

		Map<String, String> listeAllErrors = new HashMap<String, String>();

		for (IValidatorConfig currentValidator : validatorConfi.values()) {

			IZCValidator izcValidator = ZCValidatorFactory
					.getValidator(currentValidator);

			Map<String, String> currentListErrors = izcValidator.validate(
					ViewValue, propertiesMap, beanInstance);

			for (String keyValue : currentListErrors.keySet()) {

				if (listeAllErrors.containsKey(keyValue)) {

					String newErrorMessage = listeAllErrors.get(keyValue)
							+ " & " + currentListErrors.get(keyValue);

					currentListErrors.put(keyValue, newErrorMessage);

				} else {
					listeAllErrors.put(keyValue,
							currentListErrors.get(keyValue));
				}

			}
			listeAllErrors.putAll(currentListErrors);

		}

		return listeAllErrors;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Object getViewInstance() {
		return this.viewInstance;
	}

	/**
	 * <p>
	 * Returns a Map of properties whose key name is the same as value name, for
	 * the specified Class instance
	 * </p>
	 * 
	 * @param aClass
	 *            The Class instance
	 * @return
	 */
	private Map<String, String> getMapSameField(Class<? extends Object> aClass) {
		HashMap<String, String> MapSameField = new HashMap<String, String>();
		List<String> listFiledBeanName = ReflectManager.getAllField(aClass);
		for (String fieldName : listFiledBeanName) {
			MapSameField.put(fieldName, fieldName);
		}
		return MapSameField;
	}

	public void initialize() {

		izcVirtualView = ZCVirtualViewFactory.getVirtualView(viewInstance);
	}
}
