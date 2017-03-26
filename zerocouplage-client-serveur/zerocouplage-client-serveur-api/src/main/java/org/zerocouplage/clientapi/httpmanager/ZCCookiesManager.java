package org.zerocouplage.clientapi.httpmanager;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.clientapi.bean.ZCCookies;

public class ZCCookiesManager {
	
	
	private static Map<String, ZCCookies>  cookiesByApps = new HashMap<String, ZCCookies>();
	
	private ZCCookiesManager() {
	}
	
	public static ZCCookies getInstance(String applicationID)
	{
		ZCCookies cookies = cookiesByApps.get(applicationID);
		
		if(cookies == null)
		{
			cookies = new ZCCookies();
			cookiesByApps.put(applicationID, cookies);
			
		}
		
		return cookies;
	}
}
