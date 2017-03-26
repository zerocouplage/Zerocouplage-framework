package org.zerocouplage.application.mobile.view;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.application.mobile.bean.BeanUserOut;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class FormResult extends Activity {

	BeanUserOut userout;
	private IZCManager manager;
	private Button back;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main1);
		
		manager = ZCManagerFactory.getNewManager(this);
		TextView tv = (TextView) findViewById(R.id.hello);
		Bundle getintent = getIntent().getExtras();
		userout = (BeanUserOut) getintent.getSerializable("userout");

		tv.setText("Merci " + userout.getCivilite() + " "+ userout.getFirstName() + " "
				+ userout.getLastName()+" votre demande a �t� envoy�e avec succ�s !");
		
		
		
		
		
		back = (Button) findViewById(R.id.back);
		
		  
		  
		  back.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					try {
					
						manager.executeBusiness("processingAcceuil");

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}
			});
		

	}

}
