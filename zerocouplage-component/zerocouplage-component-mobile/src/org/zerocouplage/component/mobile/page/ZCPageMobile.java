package org.zerocouplage.component.mobile.page;


import org.zerocouplage.component.api.layout.ZCLayout;
import org.zerocouplage.component.impl.page.ZCAbstractPage;

import android.os.Bundle;
/**
 * <p>
 * ZCPageMobile is the ZCPage component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPageMobile extends ZCAbstractPage {
	ZCActivityMobile active= new ZCActivityMobile();
	
private Bundle savedInstanceState;
	public Object display() throws Exception {
		active.setTitle(this.getTitle());
		active.onCreate(savedInstanceState);
		active.setLayout((ZCLayout) this.getBody().display());
		
		return active;
	}
	public void setCurrentInstance(Object view) {
		
		
	}

}
