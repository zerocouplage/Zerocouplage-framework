package org.zerocouplage.component.mobile.component;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.component.impl.component.ZCAbstractCheckBox;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;
import org.zerocouplage.impl.controller.ZCManagerFactory;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;

/**
 * <p>
 * ZCCheckBoxMobile is the ZCCheckBox component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCCheckBoxMobile extends ZCAbstractCheckBox {
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCCheckBoxMobile.class);
	private CheckBox checkBox;
	
	public ZCCheckBoxMobile()
	{
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();
		checkBox = new CheckBox(parent);
	}
	
	public Object display() {
		checkBox.setText(getText());
		checkBox.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		return checkBox;

	}
	
	 public void setAction(final String actioName,final Object thisClass) {

		 checkBox.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v) {
					try {
						IZCManager manager = ZCManagerFactory.getNewManager(thisClass);
						manager.executeBusiness(actioName, false, getName());
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

	   public String getAction() {
			return this.action;
		}

}