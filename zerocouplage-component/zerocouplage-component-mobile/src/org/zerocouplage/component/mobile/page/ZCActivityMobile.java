package org.zerocouplage.component.mobile.page;

import org.zerocouplage.component.api.layout.ZCLayout;
import org.zerocouplage.component.mobile.layout.ZCFlowLayoutMobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @author Nadia ELRHOUL
 * 
 */
public class ZCActivityMobile extends Activity {

	private String title=null;
	private ZCLayout layout;
	
	public ZCActivityMobile(String title, ZCFlowLayoutMobile layout) {
		this.title = title;
		this.layout = (ZCLayout) layout;

	}
	
 
	public ZCActivityMobile() {


	}

	@Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
       try {
		setContentView((View) layout.display());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       // myLayout.addView(myButton, buttonParams);
    }

	public ZCLayout getLayout() {
		return layout;
	}

	public void setLayout(ZCLayout layout) {
		this.layout = layout;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
