package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractButton;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.component.ZCAbstractRadioButton;
import org.zerocouplage.component.mobile.page.ZCActivityMobile;
import org.zerocouplage.component.mobile.page.ZCPageMobile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;

/**
 * <p>
 * ZCRadioButtonMobile is the ZCRadioButton component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCRadioButtonMobile extends ZCAbstractRadioButton {
	
	private  RadioButton zcradiobutton;

	@Override
	public Object display() {
		Object parent = this.getParent();
		while (!(parent instanceof ZCPageMobile)) {
			parent = ((ZCAbstractComponent) parent).getParent();
		}

		zcradiobutton = new RadioButton((Context) parent);

		zcradiobutton.setText(getText());
		zcradiobutton.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		

		return zcradiobutton;

	}

}
