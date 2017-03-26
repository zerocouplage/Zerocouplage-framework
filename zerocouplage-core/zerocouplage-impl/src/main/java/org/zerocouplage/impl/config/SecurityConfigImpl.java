package org.zerocouplage.impl.config;

import org.zerocouplage.api.config.ISecurityConfig;

public class SecurityConfigImpl implements ISecurityConfig {

	private String object;
	private String name;
	private String valueTarget;
	private String errorPage;
	
	 public SecurityConfigImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.setName("");
		this.setValueTarget("");
		this.setObject("");
		this.setErrorPage("");
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueTarget() {
		return valueTarget;
	}

	public void setValueTarget(String valueTarget) {
		this.valueTarget = valueTarget;
	}
	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	
	
	
}
