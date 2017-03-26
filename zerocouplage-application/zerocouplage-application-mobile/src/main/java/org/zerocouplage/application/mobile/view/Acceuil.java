package org.zerocouplage.application.mobile.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class Acceuil extends Activity {
	private TextView lien1;
	private TextView lien2;
	private IZCManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acceuil);
		manager = ZCManagerFactory.getNewManager(this);


		lien1 = (TextView) findViewById(R.id.lien1);
		lien2 = (TextView) findViewById(R.id.lien2);
		lien1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {

					manager.executeBusiness("processingToAuthentification");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		});
		lien2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {

					manager.executeBusiness("processingToForm");

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
