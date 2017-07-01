package org.zerocouplage.component.mobile.layout;

import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.layout.ZCAbstractGridLayout;
import org.zerocouplage.component.mobile.page.ZCPageMobile;
import org.zerocouplage.component.mobile.page.ZCSharedMobilePage;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
/**
 * <p>
 * ZCGridLayoutMobile is the ZCGridLayout component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCGridLayoutMobile extends ZCAbstractGridLayout {

	@Override
	public Object display() {
		
	
		Context parent = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();

		
		GridLayout gv = new GridLayout((Context) parent);
		gv.setLayoutParams(
				new LayoutParams(getStyle().getWidth(), getStyle().getHeight()));
		gv.setColumnCount(getCols());
		gv.setRowCount(getRows());
		return gv;
	}

}

