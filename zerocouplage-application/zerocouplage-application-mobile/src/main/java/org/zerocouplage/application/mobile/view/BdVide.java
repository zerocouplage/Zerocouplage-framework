package org.zerocouplage.application.mobile.view;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BdVide  extends Activity{
	private IZCManager manager;
	private Button retour;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bdvide);
		manager = ZCManagerFactory.getNewManager(this);
		retour= (Button) findViewById(R.id.retour);
	
		

		retour.setOnClickListener(new OnClickListener() {

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