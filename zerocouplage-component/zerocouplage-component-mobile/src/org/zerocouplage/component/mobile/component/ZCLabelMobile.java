package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.component.ZCAbstractLabel;
import org.zerocouplage.component.mobile.page.ZCActivityMobile;
import org.zerocouplage.component.mobile.page.ZCPageMobile;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
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
	
	public Object display(){
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();


		label= new TextView((Context) parent);
		label.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		
		return label;

	}
	}
