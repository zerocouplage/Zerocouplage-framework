package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.component.ZCAbstractLabel;
import org.zerocouplage.component.mobile.page.ZCActivityMobile;
import org.zerocouplage.component.mobile.page.ZCPageMobile;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * <p>
 * ZCLabelMobile is the ZCLabel component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCLabelMobile  extends ZCAbstractLabel{
	
	TextView label;
	
	public ZCLabelMobile()
	{
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();
		label = new TextView(parent);
	}
	
	
	public Object display(){
		label.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		label.setText(getLabel());
		if(getStyle() != null && getStyle().getColor() != null){
			label.setTextColor(Color.parseColor(getStyle().getColor()));
		}
		
		return label;

	}
	}
