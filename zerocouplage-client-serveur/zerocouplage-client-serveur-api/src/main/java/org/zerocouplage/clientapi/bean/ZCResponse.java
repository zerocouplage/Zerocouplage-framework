package org.zerocouplage.clientapi.bean;

import java.io.File;

public class ZCResponse  extends ZCAbstractCommunication{

	
	private  String className = null;
	private String viewName;
	private String zcStatus;
	private int responseCode; 
	
	


	private Object content;
	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getZcStatus() {
		return zcStatus;
	}

	public void setZcStatus(String zcStatus) {
		this.zcStatus = zcStatus;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
}
