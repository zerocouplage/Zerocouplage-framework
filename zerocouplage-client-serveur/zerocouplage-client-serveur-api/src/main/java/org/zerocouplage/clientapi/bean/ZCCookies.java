package org.zerocouplage.clientapi.bean;

import java.util.HashMap;
import java.util.Map;

public class ZCCookies {


	private Map<String, String> listCookies;

	public ZCCookies() {
		setListCookies(new HashMap<String, String>());
	}

	public void addCookies(String cookiesName, String cookiesValue) {
		listCookies.put(cookiesName, cookiesValue);
	}

	public String getCookies(String cookiesName) {
		return listCookies.get(cookiesName);
	}

	public boolean hasCookies(String cookiesName) {
		return listCookies.containsKey(cookiesName);
	}

	public Map<String, String> getListCookies() {
		return listCookies;
	}

	public void setListCookies(Map<String, String> listCookies) {
		this.listCookies = listCookies;
	}

}
