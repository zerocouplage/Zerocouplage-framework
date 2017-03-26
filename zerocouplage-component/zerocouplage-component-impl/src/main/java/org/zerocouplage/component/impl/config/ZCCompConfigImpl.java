package org.zerocouplage.component.impl.config;

import java.util.HashMap;
import java.util.Map;
import org.zerocouplage.component.api.config.ZCCompConfig;
/**
 * 
 * @author Nadia ELRHOUL
 *
 */

public class ZCCompConfigImpl implements ZCCompConfig {
	
	protected String context;
	protected String classApi;
	protected String classImpl;
	Map<String, String> compMaper;

	public ZCCompConfigImpl() {
		compMaper = new HashMap<String, String>();

	}

	public String getClassImpl(String classApi) {
		if (compMaper.containsKey(classApi)) {
			classImpl = compMaper.get(classApi);
		}
		return classImpl;
	}

	public void add(String classApi, String classImpl) {
		compMaper.put(classApi, classImpl);
	}

	public void setClassApi(String classApi) {
		this.classApi = classApi;
	}

	public String getClassApi() {
		return classApi;
	}

	public void setClassImpl(String classImpl) {
		this.classImpl = classImpl;
	}

	public Map<String, String> getcompMaper() {
		return compMaper;
	}

	public String getClassImplement() {
		return classImpl;
	}

}