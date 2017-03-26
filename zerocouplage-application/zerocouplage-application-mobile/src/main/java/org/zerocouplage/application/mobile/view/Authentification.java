package org.zerocouplage.application.mobile.view;


import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class Authentification extends Activity {

	private Button save,retour;
	private EditText login;
	private EditText password;
	private TextView errorLabel;
	private IZCManager manager;
																				                                                                                                                                                                                                                                                                                                                                                                                                           

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auth);
	
		manager = ZCManagerFactory.getNewManager(this);

		login = (EditText) findViewById(R.id.login);
		password = (EditText) findViewById(R.id.password);
		errorLabel = (TextView) findViewById(R.id.error);



		save = (Button) findViewById(R.id.save);
		retour = (Button) findViewById(R.id.retour);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {
				
					manager.executeBusiness("processingToFullDB");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		});
		
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
  

	public String getLogin() {
		return login.getText().toString();
	}

	public  String getPassword() {
		return password.getText().toString();
	}

	


	public void processError(HashMap<String, String> listError) {
		    errorLabel.setText(listError.get("GLOBAL_MESSAGE"));
			login.setError(listError.get("error_login"));
			password.setError(listError.get("error_password"));
			

	}


}
