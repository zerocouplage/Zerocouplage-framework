package org.zerocouplage.component.mobile.component;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.component.impl.component.ZCAbstractButton;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;
import org.zerocouplage.impl.controller.ZCManagerFactory;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

/**
 * <p>
 * ZCButtonMobile is the ZCButton component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCButtonMobile extends ZCAbstractButton {
	private static IZCLogger logger = ZCLoggerFactory.getLogger(ZCButtonMobile.class);
	private Button button;

	public ZCButtonMobile()
	{
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();
		button = new Button(parent);
	}
	public Object display() {
		
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		button.setLayoutParams(layoutParams);
		
		if (getStyle() != null) {
			if (getStyle().getWidth() != 0) {
				layoutParams.width = getStyle().getWidth();
			}
			if (getStyle().getHeight() != 0) {
				layoutParams.height = getStyle().getHeight();
			}
			if (getStyle().getColor() != null) {
				button.setBackgroundColor(Color.parseColor(getStyle().getColor()));
			}
		}
		button.setText(getText());
		return button;
	}

	public void setAction(final String actioName, final Object thisClass) {

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					IZCManager manager = ZCManagerFactory.getNewManager(thisClass);
					manager.executeBusiness(actioName, false, getName());
				} catch (ClassNotFoundException e) {
					logger.error(
							"the business indicated in you're button's action is not found in the zerocouplage.xml");

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
	
	public String getText() {
		return button.getText().toString();
	}
	
	public void setText(String text) {
		button.setText(text);
	}

}
