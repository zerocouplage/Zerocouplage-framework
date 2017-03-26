package org.zerocouplage.test.mobile.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;
import org.zerocouplage.test.mobile.business.Dao;

public class UserView extends Activity implements OnClickListener{

	private Button save , button;
	private EditText lastname;
	private EditText firstname;
	private EditText nbAnneeExp;
	private EditText mail, birthday;
	private RadioGroup civilite;
	
	private TextView cv;
	
	File f;
	private TextView errorLabel;
	private IZCManager manager;
	private Bundle getintent;
	private File fil;

	String[] strings = { "Stage", "Poste" };
	private Spinner mySpinner;

	public String getMySpinner() {

		String selected = (String) mySpinner.getSelectedItem();

		return selected;
	}

	private static final int REQUEST_PICK_FILE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		try {
			Dao db = new Dao();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		mySpinner = (Spinner) findViewById(R.id.spinner);
		mySpinner.setAdapter(new MyAdapter(UserView.this, R.layout.row5,
				strings));


		cv = (TextView) findViewById(R.id.file_path_text_view);
		 button = (Button) findViewById(R.id.uploaad);
			manager = ZCManagerFactory.getNewManager(this);


		button.setOnClickListener(this);

		getintent = getIntent().getExtras();

		lastname = (EditText) findViewById(R.id.lastname);
		firstname = (EditText) findViewById(R.id.firstname);
		nbAnneeExp = (EditText) findViewById(R.id.experience);
		mail = (EditText) findViewById(R.id.email);
		birthday = (EditText) findViewById(R.id.birthday);
		civilite = (RadioGroup) findViewById(R.id.choice);

		
		errorLabel = (TextView) findViewById(R.id.error);
		fil = new File("/etc/event-log-tags");

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

	public String getCv() {

		System.out.println("sysooooooooooooooooooooooo   "
				+ cv.getText().toString());
		return cv.getText().toString();
	}

	public String getLastName() {
		return lastname.getText().toString();
	}

	public String getBirthday() {
		return birthday.getText().toString();
	}

	public String getNbAnneeExp() {
		return nbAnneeExp.getText().toString();
	}

	//
	public String getMail() {
		return mail.getText().toString();
	}

	public String getCivilite() {
		String response = "";
		int selected = civilite.getCheckedRadioButtonId();
		RadioButton b = (RadioButton) findViewById(selected);
		String s = (String) b.getText();
		if ("Mr".equals(s)) {
			response = "Mr";
		} else if ("Mme".equals(s)) {
			response = "Mme";
		} else {
			response = "Mlle";

		}
		return response;
	}

	
	//
	public String getFil() {
		return fil.getAbsolutePath();
	}

	public void processError(HashMap<String, String> listError) {
		errorLabel.setText(listError.get("GLOBAL_MESSAGE"));
		lastname.setError(listError.get("error_lastName"));
		firstname.setError(listError.get("error_firstName"));
		mail.setError(listError.get("error_mail"));
		nbAnneeExp.setError(listError.get("error_nbAnneeExp"));
		birthday.setError(listError.get("error_birthday"));
	//	fil.setError(listError.get("error_"));

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.uploaad:
			// Create a new Intent for the file picker activity
			Intent intent = new Intent(this, FilePickerActivity.class);

			// Set the initial directory to be the sdcard
			// intent.putExtra(FilePickerActivity.EXTRA_FILE_PATH,
			// Environment.getExternalStorageDirectory());

			// Show hidden files
			// intent.putExtra(FilePickerActivity.EXTRA_SHOW_HIDDEN_FILES,
			// true);

			// Only make .png files visible
			// ArrayList<String> extensions = new ArrayList<String>();
			// extensions.add(".png");
			// intent.putExtra(FilePickerActivity.EXTRA_ACCEPTED_FILE_EXTENSIONS,
			// extensions);

			// Start the activity
			startActivityForResult(intent, REQUEST_PICK_FILE);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_PICK_FILE:
				if (data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH)) {
					// Get the file path
					f = new File(
							data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));

					// Set the file path text view
					cv.setText(f.getPath());
					System.out.println("thes contenu" + f.getAbsolutePath());
					StringBuilder fileData = new StringBuilder();
					BufferedReader reader;
					try {
						reader = new BufferedReader(new FileReader(
								"/etc/event-log-tags"));
						char[] buf = new char[1024];
						int numRead = 0;
						while ((numRead = reader.read(buf)) != -1) {
							StringBuilder test = fileData.append(buf, 0,
									numRead);
							System.out.println("the contenu is +" + test);
						}
						reader.close();
						fileData.toString();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

	// ---------------------------------------------- Adapter pour le spinner
	// -------------------------------------------------------

	class MyAdapter extends ArrayAdapter<String> {

		public MyAdapter(Context context, int textViewResourceId,
				String[] objects) {

			super(context, textViewResourceId, objects);
		}

		@Override
		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			return getCustomView(position, convertView, parent);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return getCustomView(position, convertView, parent);
		}

		public View getCustomView(int position, View convertView,
				ViewGroup parent) {

			LayoutInflater inflater = getLayoutInflater();

			View row = inflater.inflate(R.layout.row5, parent, false);
			TextView label = (TextView) row.findViewById(R.id.company);

			label.setText(strings[position]);

			return row;
		}

	}

}
