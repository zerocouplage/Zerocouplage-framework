package org.zerocouplage.application.mobile.view;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.application.mobile.bean.BeanUser;
import org.zerocouplage.application.mobile.business.RecrutBusiness;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class DataAccess extends Activity {

	TableLayout tl;
	TableRow tr;
	TextView myname, mylastname, mybirth, myemail, myexperience, mycivilite,
			mytype, mydate;
	List<BeanUser> candidatList;
	Button action, suprimer;
	BeanUser myCandidat;
	String path="", id="";
	IZCManager manager;
	DataAccess myDataAccess;
	private Button retour;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		createTable();
	}

	public void createTable() {

		manager = ZCManagerFactory.getNewManager(this);
		if(RecrutBusiness.getDataFromCandidat().size()==0){
			try {
				manager.executeBusiness("bdVide");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		myDataAccess = this;

		tl = (TableLayout) findViewById(R.id.maintable);
		candidatList = RecrutBusiness.getDataFromCandidat();

		addHeaders();
		addData();
		retour = (Button) findViewById(R.id.retour);

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

	public void setIdCandidat(String id) {
		this.id = id;
	}

	public void setPathCv(String path) {
		this.path = path;
	}

	public String getIdCandidat() {
		return this.id;
	}

	public String getPathCv() {
		return this.path;
	}

	public void addHeaders() {

		tr = new TableRow(this);
		tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		TextView companyTV = new TextView(this);
		companyTV.setText("Nom");
		companyTV.setTextColor(Color.GRAY);
		companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		companyTV.setPadding(5, 5, 5, 0);
		tr.addView(companyTV); 

		TextView valueTV = new TextView(this);
		valueTV.setText("Pr�nom");
		valueTV.setTextColor(Color.GRAY);
		valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		valueTV.setPadding(5, 5, 5, 0);
		valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(valueTV); 

		TextView date_View = new TextView(this);
		date_View.setText("date");
		date_View.setTextColor(Color.GRAY);
		date_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		date_View.setPadding(5, 5, 5, 0);
		date_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(date_View);

		TextView email_View = new TextView(this);
		email_View.setText("Email");
		email_View.setTextColor(Color.GRAY);
		email_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		email_View.setPadding(5, 5, 5, 0);
		email_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(email_View);

		TextView civilit�_View = new TextView(this);
		civilit�_View.setText("Civilit�");
		civilit�_View.setTextColor(Color.GRAY);
		civilit�_View.setLayoutParams(new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		civilit�_View.setPadding(5, 5, 5, 0);
		civilit�_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(civilit�_View);

		TextView experience_View = new TextView(this);
		experience_View.setText("nbre exp�rience");
		experience_View.setTextColor(Color.GRAY);
		experience_View.setLayoutParams(new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		experience_View.setPadding(5, 5, 5, 0);
		experience_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(experience_View);

		TextView type_View = new TextView(this);
		type_View.setText("Type de la demande");
		type_View.setTextColor(Color.GRAY);
		type_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		type_View.setPadding(5, 5, 5, 0);
		type_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(type_View);

		TextView datedemande_View = new TextView(this);
		datedemande_View.setText("Date de la demande");
		datedemande_View.setTextColor(Color.GRAY);
		datedemande_View.setLayoutParams(new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		datedemande_View.setPadding(5, 5, 5, 0);
		datedemande_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(datedemande_View);
		TextView action_View = new TextView(this);
		action_View.setText("Action");
		action_View.setTextColor(Color.GRAY);
		action_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		action_View.setPadding(5, 5, 5, 0);
		action_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(action_View);

		TextView suprimer_View = new TextView(this);
		suprimer_View.setText("Supprimer");
		suprimer_View.setTextColor(Color.GRAY);
		suprimer_View.setLayoutParams(new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		suprimer_View.setPadding(5, 5, 5, 0);
		suprimer_View.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		tr.addView(suprimer_View);

		tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		tr = new TableRow(this);
		tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

	}

	public void addData() {

		Iterator iter = candidatList.iterator();
		while (iter.hasNext()) {
			myCandidat = (BeanUser) iter.next();
			tr = new TableRow(this);
			tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			/** Creating a TextView to add to the row **/
			myname = new TextView(this);
			myname.setText(myCandidat.getNom());
			myname.setTextColor(Color.WHITE);
			myname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			myname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			myname.setPadding(5, 5, 5, 5);
			tr.addView(myname); 

			mylastname = new TextView(this);
			mylastname.setText(myCandidat.getPrenom());
			mylastname.setTextColor(Color.WHITE);
			mylastname.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			mylastname.setPadding(5, 5, 5, 5);
			mylastname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(mylastname); 

			mybirth = new TextView(this);
			mybirth.setText(myCandidat.getDan().toGMTString());
			mybirth.setTextColor(Color.WHITE);
			mybirth.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			mybirth.setPadding(5, 5, 5, 5);
			mybirth.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(mybirth);
			myemail = new TextView(this);
			myemail.setText(myCandidat.getEmail());
			myemail.setTextColor(Color.WHITE);
			myemail.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			myemail.setPadding(5, 5, 5, 5);
			myemail.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(myemail); 

			mycivilite = new TextView(this);
			mycivilite.setText(myCandidat.getCivilite());
			mycivilite.setTextColor(Color.WHITE);
			mycivilite.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			mycivilite.setPadding(5, 5, 5, 5);
			mycivilite.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(mycivilite); 

			myexperience = new TextView(this);
			myexperience.setText(String.valueOf(myCandidat.getNbAnneeExp()));
			myexperience.setTextColor(Color.WHITE);
			myexperience.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			myexperience.setPadding(5, 5, 5, 5);
			myexperience.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(myexperience); 

			mytype = new TextView(this);
			mytype.setText(myCandidat.getNatureDemande());
			mytype.setTextColor(Color.WHITE);
			mytype.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			mytype.setPadding(5, 5, 5, 5);
			mytype.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(mytype);

			mydate = new TextView(this);
			mydate.setText(myCandidat.getDateDemande().toGMTString());
			mydate.setTextColor(Color.WHITE);
			mydate.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT));
			mydate.setPadding(5, 5, 5, 5);
			mydate.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(mydate);

			action = new Button(this);
			action.setText("voir CV");
			action.setBackgroundResource(R.drawable.btn_mobile);
			action.setTextColor(Color.WHITE);
			action.setPadding(5, 5, 5, 5);

			OnClickListenerShowCV listnerShowCv = new OnClickListenerShowCV();
			listnerShowCv.setCv_path(myCandidat.getPath());
			action.setOnClickListener(listnerShowCv);
			tr.addView(action);

			suprimer = new Button(this);
			suprimer.setText("Supprimer");
			suprimer.setBackgroundResource(R.drawable.btn_mobile);
			suprimer.setTextColor(Color.WHITE);
			suprimer.setPadding(5, 5, 5, 5);
			OnClickListenerDelet listnerDelet = new OnClickListenerDelet();
			listnerDelet.setId_condidat(String.valueOf(myCandidat.getIdUser()));
			suprimer.setOnClickListener(listnerDelet);
			tr.addView(suprimer);

			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		}
	}

	class OnClickListenerDelet implements OnClickListener {

		String id_condidat;

		public void setId_condidat(String id_condidat) {
			this.id_condidat = id_condidat;
		}

		public String getId_condidat() {
			return id_condidat;
		}

		@Override
		public void onClick(View arg0) {
			try {
				myDataAccess.setIdCandidat(getId_condidat());
				manager.executeBusiness("deleteCandidat", true);
				finish();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}

	}

	class OnClickListenerShowCV implements OnClickListener {

		String cv_path;

		public void setCv_path(String cv_path) {
			this.cv_path = cv_path;
		}

		public String getCv_path() {
			return cv_path;
		}

		@Override
		public void onClick(View arg0) {
			try {
				myDataAccess.setPathCv(getCv_path());
				manager.executeBusiness("showCv");
				finish();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}

	}

}