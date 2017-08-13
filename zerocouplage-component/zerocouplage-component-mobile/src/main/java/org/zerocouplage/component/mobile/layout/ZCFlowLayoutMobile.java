package org.zerocouplage.component.mobile.layout;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.layout.ZCAbstractFlowLayout;
import org.zerocouplage.component.mobile.page.ZCPageMobile;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

/**
 * <p>
 * ZCFlowLayoutMobile is the ZCFlowLayout component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCFlowLayoutMobile extends ZCAbstractFlowLayout {

	@Override
	public Object display() throws Exception {

		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();

		LinearLayout linearLayout = new LinearLayout((Context) parent);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		linearLayout.setLayoutParams(layoutParams);
		
		if (getStyle() != null) {
			if (getStyle().getWidth() != 0) {
				layoutParams.width = getStyle().getWidth();
			}
			if (getStyle().getHeight() != 0) {
				layoutParams.height = getStyle().getHeight();
			}
			if (getStyle().getColor() != null) {
				linearLayout.setBackgroundColor(Color.parseColor(getStyle().getColor()));
			}
		}

		if (getDirection() == X_DIRECTION) {
			linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		} else if (getDirection() == Y_DIRECTION) {
			linearLayout.setOrientation(LinearLayout.VERTICAL);
		}

		for (ZCComponent currentComponent : getComponent()) {
			linearLayout.addView((View) currentComponent.display());
		}

		return linearLayout;
	}

}
