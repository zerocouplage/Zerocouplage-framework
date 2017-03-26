package org.zerocouplage.component.mobile.layout;

import java.util.ArrayList;

import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.layout.ZCAbstractFlowLayout;
import org.zerocouplage.component.mobile.page.ZCPageMobile;

import android.annotation.SuppressLint;
import android.content.Context;
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

	
	@SuppressLint("NewApi")
	@Override
	public Object display() throws Exception {

		Object parent = this.getParent();
		while (!(parent instanceof ZCPageMobile)) {
			parent = ((ZCAbstractComponent) parent).getParent();
		}
		LinearLayout zcLayout = new LinearLayout((Context) parent);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				new LayoutParams(getStyle().getWidth(), getStyle().getHeight()));

		layoutParams.setMargins(30, 20, 30, 0);
		if (getDirection() == X_DIRECTION) {
			zcLayout.setOrientation(LinearLayout.HORIZONTAL);
		} else if (getDirection() == Y_DIRECTION) {
			zcLayout.setOrientation(LinearLayout.VERTICAL);
		}

		int count = zcLayout.getChildCount();
		View v = null;
		while (count <= getComponent().size()) {

			v = zcLayout.getChildAt(count);
			zcLayout.getChildAt(count).addChildrenForAccessibility(
					(ArrayList<View>) getComponent().get(count).display());


		}

		return zcLayout;
	}

}
