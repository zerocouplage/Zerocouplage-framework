package org.zerocouplage.test.mobile.view;

import java.io.File;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class UserView extends Activity {

	private Button save;
	private EditText lastname;
	private EditText firstname;
	private EditText age;
	private EditText size, birthday;
	private RadioGroup choice;
	private TextView errorLabel;
	private IZCManager manager;
	private Bundle getintent;
	private File fil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		manager = ZCManagerFactory.getNewManager(this);
		getintent = getIntent().getExtras();

		lastname = (EditText) findViewById(R.id.lastname);
		firstname = (EditText) findViewById(R.id.firstname);
		age = (EditText) findViewById(R.id.age);
		size = (EditText) findViewById(R.id.size);
		birthday = (EditText) findViewById(R.id.birthday);
		choice = (RadioGroup) findViewById(R.id.choice);
		errorLabel = (TextView) findViewById(R.id.error);
		fil=new File("/etc/event-log-tags");

//		if (getintent != null) {
//			errorLabel.setText(getintent.getString("GLOBAL_MESSAGE"));
//			lastname.setError(getintent.getString("error_lastName"));
//			firstname.setError(getintent.getString("error_firstName"));
//			size.setError(getintent.getString("error_sizee"));
//			age.setError(getintent.getString("error_age"));
//			birthday.setError(getintent.getString("error_birthday"));
//		}

		save = (Button) findViewById(R.id.save);

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {
				
					manager.executeBusiness("processing");

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

	public String getFirstName() {
		return firstname.getText().toString();
	}

	public String getLastName() {
		return lastname.getText().toString();
	}

	public String getBirthday() {
		return birthday.getText().toString();
	}

	public String getAge() {
		return age.getText().toString();
	}

	//
	public String getSizee() {
		return size.getText().toString();
	}

	public String getQuestion() {
		String response = "";
		int selected = choice.getCheckedRadioButtonId();
		RadioButton b = (RadioButton) findViewById(selected);
		String s = (String) b.getText();
		if ("Yes".equals(s)) {
			response = "true";
		} else {
			response = "false";
		}
		return response;
	}
	
	public String getFil(){
		return fil.getAbsolutePath();
	}
	
	public void processError(HashMap<String, String> listError) {
		    errorLabel.setText(listError.get("GLOBAL_MESSAGE"));
			lastname.setError(listError.get("error_lastName"));
			firstname.setError(listError.get("error_firstName"));
			size.setError(listError.get("error_sizee "));
			age.setError(listError.get("error_age"));
			birthday.setError(listError.get("error_birthday"));

	}

}
