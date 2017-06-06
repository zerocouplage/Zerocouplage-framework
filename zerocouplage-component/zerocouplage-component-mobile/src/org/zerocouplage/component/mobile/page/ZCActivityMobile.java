package org.zerocouplage.component.mobile.page;

import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;
import org.zerocouplage.impl.controller.ZCManagerFactory;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Nadia ELRHOUL
 * 
 */
public class ZCActivityMobile extends Activity {


	@Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        ZCSharedMobilePage.getINSTANCE().setMainActivityForCurrentApp(this);
        
		IZCManager manager = ZCManagerFactory.getNewManager(this);
		IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();
		zcConfig.getLoaderConfig().setContext("mobile");
		
		try {
			manager.executeBusiness("index");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
