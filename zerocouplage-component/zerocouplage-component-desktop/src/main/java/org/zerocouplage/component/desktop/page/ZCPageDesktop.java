package org.zerocouplage.component.desktop.page;

import javafx.application.Application;

import org.zerocouplage.component.impl.page.ZCAbstractPage;

/**
 * <p>
 * ZCPageDesktop is the ZCPage component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPageDesktop extends ZCAbstractPage {

	
	
	private ZCFXApplication fxapp;

	public ZCPageDesktop() throws Exception  {
		this.setFxapp(new ZCFXApplication());

		
		

	}

	public Object display() throws Exception {

		
		fxapp.setTitle(this.getTitle());
		fxapp.setLayout(this.getBody().display());
		return getFxapp();
		
	}

	public ZCFXApplication getFxapp() {
		return fxapp;
	}

	public void setFxapp(ZCFXApplication fxapp) {
		this.fxapp = fxapp;
	}

	public void setCurrentInstance(Object view) {
		
		
	}

}
