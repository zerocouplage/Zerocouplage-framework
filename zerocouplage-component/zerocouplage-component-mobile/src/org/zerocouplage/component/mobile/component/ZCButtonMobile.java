package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractButton;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.mobile.page.ZCPageMobile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * ZCButtonMobile is the ZCButton component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCButtonMobile extends ZCAbstractButton {
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCButtonMobile.class);
	private Button button;
	public Object display(){
		
		Object parent = this.getParent();
		while(! (parent instanceof ZCPageMobile)){
			parent = ((ZCAbstractComponent) parent).getParent();
		}
	    	
	button = new Button( (Context) parent);
	button.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
	return button;
	}

	public void setAction(final String actionName, final IZCManager manager) {

	
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) {
				try {
					manager.executeBusiness(actionName, false, getName());
				} catch (ClassNotFoundException e) {
					logger.error("the business indicated in you're button's action is not found in the zerocouplage.xml");
					
					e.printStackTrace();
				} catch (InstantiationException e) {
					
					logger.error("error while instanciating the class");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					logger.error("error illegalAccess");
					e.printStackTrace();
				}
			          
			}

			
		});
	
	
		
	}

	public void setAction(String actioName,Object thisClass) {
	
		
	}

	public String getAction() {
		
		return null;
	}
}
