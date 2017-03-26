package org.zerocouplage.component.mobile.component;

import org.zerocouplage.component.impl.component.ZCAbstractCheckBox;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.mobile.page.ZCPageMobile;

import android.content.Context;
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
	private CheckBox checkBox;
	public Object display() {
		Object parent = this.getParent();
		while (!(parent instanceof ZCPageMobile)) {
			parent = ((ZCAbstractComponent) parent).getParent();
		}

		checkBox = new CheckBox((Context) parent);
		checkBox.setText(getText());
		checkBox.setLayoutParams(new  LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		return checkBox;

	}
}