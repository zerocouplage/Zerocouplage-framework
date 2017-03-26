package org.zerocouplage.clientapi.bean;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ZCRequest extends ZCAbstractCommunication{

	
	private String businessName;
	private Map<String, String> mapParams;
	private File  fileUpload;
	private String fileFieledName;
	
	
	public ZCRequest() {
		setMapParams(new HashMap<String, String>());
	}
	
	public void addParam(String paramName, String paramValue) {
		mapParams.put(paramName, paramValue);
	}

	public String getParam(String paramName) {
		return mapParams.get(paramName);
	}

	public boolean hasParam(String paramName) {
		return mapParams.containsKey(paramName);
	}
	
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public String getUri() {
		return businessName+".zc";
	}

	public Map<String, String> getMapParams() {
		return mapParams;
	}

	public void setMapParams(Map<String, String> mapParams) {
		this.mapParams = mapParams;
	}

	public String formatParams() {
		
		Set<String> setKey = mapParams.keySet();
		StringBuilder formatParamsBuilder = new StringBuilder();
		String formatParams = "";
		for (Iterator<String> iterator = setKey.iterator(); iterator.hasNext();) 
		{
			String paramName = (String) iterator.next();
			String paramValue = mapParams.get(paramName);
			formatParamsBuilder.append('&');
			formatParamsBuilder.append(paramName);
			formatParamsBuilder.append('=');
			formatParamsBuilder.append(paramValue);
		}
		
		if(formatParamsBuilder.length() > 0)
		{
			formatParams = formatParamsBuilder.substring(1);
		}
		
		return formatParams;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileFieledName() {
		return fileFieledName;
	}

	public void setFileFieledName(String fileFieledName) {
		this.fileFieledName = fileFieledName;
	}

}
