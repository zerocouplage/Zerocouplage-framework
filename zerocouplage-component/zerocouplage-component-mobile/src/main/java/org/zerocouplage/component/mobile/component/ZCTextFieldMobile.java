package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.component.ZCAbstractTextField;
import org.zerocouplage.component.mobile.page.ZCActivityMobile;
import org.zerocouplage.component.mobile.page.ZCPageMobile;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

/**
 * <p>
 * ZCTextFieldMobile is the ZCTextField component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTextFieldMobile extends ZCAbstractTextField {

	private EditText zcTextField;

	public Object display() {
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();

		zcTextField = new EditText((Context) parent);
		
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		
		if (getStyle() != null) {
			zcTextField.setLayoutParams(layoutParams);
			if (getStyle().getWidth() != 0) {
				layoutParams.width = getStyle().getWidth();
			}
			if (getStyle().getHeight() != 0) {
				layoutParams.height = getStyle().getHeight();
			}
			if (getStyle().getColor() != null) {
				zcTextField.setBackgroundColor(Color.parseColor(getStyle().getColor()));
			}
		}
		
		zcTextField.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		zcTextField.setHint(getPlaceHolder());
		return zcTextField;
	}
}