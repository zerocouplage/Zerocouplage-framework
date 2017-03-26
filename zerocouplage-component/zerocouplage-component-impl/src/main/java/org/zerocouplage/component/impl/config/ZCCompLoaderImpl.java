package org.zerocouplage.component.impl.config;

import java.io.InputStream;

import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.zerocouplage.component.api.config.ZCCompConfig;
import org.zerocouplage.component.api.config.ZCCompLoader;


/**
 * 
 * 
 * @author Nadia ELRHOUL
 * 
 */
public class ZCCompLoaderImpl implements ZCCompLoader {

	
	private ZCCompConfig zcconfig;
	@SuppressWarnings("unused")
	private String Context;

	private static ZCCompLoaderImpl instance;

	// jdom
	private static Document document;
	private static Element ZCroot;


	InputStream path_ZCComp;
	private ZCCompLoaderImpl() {

		LoaderXML();
	}

	public ZCCompLoaderImpl(String path) {

		SAXBuilder sxb = new SAXBuilder();
		try {
			//document = sxb.build(new File(path));
			path_ZCComp = this.getClass().getClassLoader().getResourceAsStream(path);
			
			
			
			document = sxb.build(path_ZCComp);
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		ZCroot = document.getRootElement();
		Context = ZCroot.getAttributeValue("context");

	}

	// make sure that the instance doesn't equal null
	public static ZCCompLoaderImpl getInstance() {
		if (instance == null) {
			instance = new ZCCompLoaderImpl();
		}
		return instance;
	}

	//
	public void LoaderXML() {

		if (zcconfig == null || zcconfig.getcompMaper().size() == 0) {
			zcconfig = new ZCCompConfigImpl();
		//Element ZCComponents = (Element) ZCroot.getChildren("ZCComponent");
		
			List<Element> listZCComponent = ZCroot.getChildren("ZCComponent");

			Iterator<Element> iter = listZCComponent.iterator();
			
			while (iter.hasNext()) {
			
				Element element = iter.next();
				zcconfig.setClassApi(element.getAttributeValue("classApi"));
				String api = zcconfig.getClassApi();
				zcconfig.setClassImpl(element.getAttributeValue("classImpl"));
				
				String impl = zcconfig.getClassImplement();
				zcconfig.add(api, impl);

			}

		}

	}

	public ZCCompConfig getConfig() {
		return zcconfig;
	}

}