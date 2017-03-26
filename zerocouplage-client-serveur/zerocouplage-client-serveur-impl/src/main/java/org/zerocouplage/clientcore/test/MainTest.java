package org.zerocouplage.clientcore.test;

import org.zerocouplage.clientapi.bean.ZCCookies;
import org.zerocouplage.clientapi.bean.ZCRequest;
import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.clientapi.exceptions.ZCClientException;
import org.zerocouplage.clientapi.httpmanager.IZCHttpManager;
import org.zerocouplage.clientapi.httpmanager.ZCCookiesManager;
import org.zerocouplage.clientcore.manager.ZCHttpManager;

public class MainTest {

	public static void main(String[] args) 
	{
		IZCHttpManager zcHttpManager = new ZCHttpManager();
		
		ZCRequest request = new ZCRequest();

		zcHttpManager.setURLApplication("http://localhost:8080/ZCAppsDemo/");
		ZCCookies cookies = ZCCookiesManager.getInstance(zcHttpManager.getURLApplication());
		cookies.addCookies("datr", "7lVLVR2ivHIttFOK8K98QJBG");
	//	cookies.addCookies("datr", "7lVLVRhshshHIttFOK8K98QJBG");
		zcHttpManager.setAgent("ZCDesktop");
		
		request.setBusinessName("traitement");
		request.addParam("_ZC_SOURCE_VIEW_NAME", "authentification");
		request.addParam("login", "admin");
		request.addParam("password", "admin");
		
		System.out.println("ok");
		
		ZCResponse response = null;
		try {
			response = zcHttpManager.send(request);
			System.out.println("response.Content = "+response.getContent());
			
			System.out.println("nombre des cookies = "+cookies.getListCookies().size());
			
		} catch (ZCClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
