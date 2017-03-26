package org.zerocouplage.rolemanager.security;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.component.api.component.ZCComponent;

public class RealMapComponent {

	private Map<String, ZCComponent> componentMap = new HashMap<String, ZCComponent>();
	private ZCComponent comp;
	private String key;

	public RealMapComponent(Map<String, ZCComponent> in) {
		for (String mapKey : in.keySet()) {
			comp = in.get(mapKey);
			componentMap.put(mapKey, comp);

		}
	}

	@SuppressWarnings("null")
	public Object display() throws Exception {
		Map<String, Object> componentMapProxy = new HashMap<String, Object>();
		Object K = null;
		String i = "";
		Object maValeur = new Object();

		for (String mapKey : componentMap.keySet()) {
			K = componentMap.get(mapKey).display();
			componentMapProxy.put(mapKey, K);

		}

		for (String maCle : componentMapProxy.keySet()) {
			maValeur = componentMapProxy.get(maCle);
			i += maValeur;
			// System.out.println(i);
		}

		return i;
	}

	public Map<String, ZCComponent> getComponentMap() {
		return componentMap;
	}

	public void setComponentMap(Map<String, ZCComponent> componentMap) {
		this.componentMap = componentMap;
	}

}
