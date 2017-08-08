package org.zerocouplage.component.mobile.page;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;

import android.view.View;
/**
 * <p>
 * ZCSharedPage is the common window for all components, it's instantiated 
 * on the first level.
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCSharedMobilePage {

	private static ZCSharedMobilePage INSTANCE;
	
	//Ce map contient les activity de toutes les applications ZC du meme support mobile (une par applications)
	private Map<String, ZCActivityMobile> mapAllMainActivity; 
	
	
	/**
	 * <p>
	 * constructor of the component
	 * </p>
	 * 
	 */
	private ZCSharedMobilePage() {
		mapAllMainActivity = new HashMap<String, ZCActivityMobile>();
	}
	/**
	 * <p>
	 * gets instance of the component
	 * </p>
	 * 
	 *@return instance 
	 */
	public static ZCSharedMobilePage getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new ZCSharedMobilePage();
		}
		return INSTANCE;
	}

	/**
	 * <p>
	 * Method draws our page over the first window that had already created
	 * </p>
	 * 
	 *@param currentPage
	 *@throws Exception
	 */
	public void drawPage(ZCPage currentPage) throws Exception {

		View zcApps = (View) currentPage.display();
		ZCActivityMobile mainActivity = getMainActivityForCurrentApp();
		mainActivity.setContentView(zcApps);

	}
	
	public void setMainActivityForCurrentApp(ZCActivityMobile mainActivity) {
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		String appName = zcConfig.getLoaderConfig().getAppName();
		mapAllMainActivity.put(appName, mainActivity);
	}
	
	public ZCActivityMobile getMainActivityForCurrentApp()
	{
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		String appName = zcConfig.getLoaderConfig().getAppName();
		ZCActivityMobile mainActivity = mapAllMainActivity.get(appName);
		return mainActivity;
	}

	 
}
