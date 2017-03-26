package org.zerocouplage.test.mobile.view;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;
import org.zerocouplage.test.mobile.bean.Candidat;
import org.zerocouplage.test.mobile.business.Dao;
import org.zerocouplage.test.mobile.business.DataProcess;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
 
public class table extends Activity {
	
 
  
 
     TableLayout tl;
     TableRow tr;
     TextView myname,mylastname,mybirth,myemail,myexperience,mycivilite,mytype,mydate;
     List<Candidat> candidatList;
     Button action,suprimer;
     Candidat myCandidat;
 	 String path, id;
 	 IZCManager manager;
 	 table myDataAccess;


 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
		manager = ZCManagerFactory.getNewManager(this);
		myDataAccess=this;

        path="";
        id="";
        tl = (TableLayout) findViewById(R.id.maintable);
        Dao db = null;
		 candidatList = DataProcess.getData();

        addHeaders();
        addData();
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
    /** This function add the headers to the table **/
    public void addHeaders(){
 
         /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
 
        /** Creating a TextView to add to the row **/
        TextView companyTV = new TextView(this);
        companyTV.setText("Nom");
        companyTV.setTextColor(Color.GRAY);
        companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        companyTV.setPadding(5, 5, 5, 0);
        tr.addView(companyTV);  // Adding textView to tablerow.
 
        /** Creating another textview **/
        TextView valueTV = new TextView(this);
        valueTV.setText("Pr�nom");
        valueTV.setTextColor(Color.GRAY);
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        valueTV.setPadding(5, 5, 5, 0);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV); // Adding textView to tablerow.
        
        TextView date_View = new TextView(this);
        date_View.setText("date");
        date_View.setTextColor(Color.GRAY);
        date_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        date_View.setPadding(5, 5,5,0);
        date_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(date_View);
        
        TextView email_View = new TextView(this);
        email_View.setText("Email");
        email_View.setTextColor(Color.GRAY);
        email_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        email_View.setPadding(5, 5, 5, 0);
        email_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(email_View);
        
        TextView civilit�_View = new TextView(this);
        civilit�_View.setText("Civilit�");
        civilit�_View.setTextColor(Color.GRAY);
        civilit�_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        civilit�_View.setPadding(5, 5, 5, 0);
        civilit�_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(civilit�_View);
        
        TextView experience_View  = new TextView(this);
        experience_View.setText("nbre exp�rience");
        experience_View.setTextColor(Color.GRAY);
        experience_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        experience_View.setPadding(5, 5, 5, 0);
        experience_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(experience_View);
        
        TextView type_View = new TextView(this);
        type_View.setText("Type de la demande");
        type_View.setTextColor(Color.GRAY);
        type_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        type_View.setPadding(5, 5, 5, 0);
        type_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(type_View);
        
        TextView datedemande_View = new TextView(this);
        datedemande_View.setText("Date de la demande");
        datedemande_View.setTextColor(Color.GRAY);
        datedemande_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        datedemande_View.setPadding(5, 5, 5, 0);
        datedemande_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(datedemande_View);
        TextView action_View = new TextView(this);
        action_View.setText("Action");
        action_View.setTextColor(Color.GRAY);
        action_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        action_View.setPadding(5, 5, 5, 0);
        action_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(action_View);
        
        
        TextView suprimer_View = new TextView(this);
        suprimer_View.setText("Supprimer");
        suprimer_View.setTextColor(Color.GRAY);
        suprimer_View.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        suprimer_View.setPadding(5, 5, 5, 0);
        suprimer_View.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        tr.addView(suprimer_View);
        
        
        
        
        
//        TextView Date_naissance = new TextView(this);
//        valueTV.setText("date de naissance");
//        valueTV.setTextColor(Color.GRAY);
//        valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//        valueTV.setPadding(5, 5, 5, 0);
//        tr.addView(Date_naissance);
 
        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
 
        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
 
    }
 
    /** This function add the data to the table **/
    @SuppressLint("NewApi")
	public void addData(){
 
    	Iterator iter = candidatList.iterator();
		while (iter.hasNext()) {
			 myCandidat = (Candidat) iter.next();
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
            /** Creating a TextView to add to the row **/
            myname = new TextView(this);
            myname.setText(myCandidat.getNom());
            myname.setTextColor(Color.RED);
            myname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            myname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            myname.setPadding(5, 5, 5, 5);
            tr.addView(myname);  // Adding textView to tablerow.
 
            /** Creating another textview **/
            mylastname = new TextView(this);
            mylastname.setText(myCandidat.getPrenom());
            mylastname.setTextColor(Color.GREEN);
            mylastname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            mylastname.setPadding(5, 5, 5, 5);
            mylastname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(mylastname); // Adding textView to tablerow.
            
            /** Creating another textview **/
           mybirth = new TextView(this);
           mybirth.setText(myCandidat.getDan());
           mybirth.setTextColor(Color.GREEN);
           mybirth.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
           mybirth.setPadding(5, 5, 5, 5);
           mybirth.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(mybirth); // Adding textView to tablerow.
            myemail = new TextView(this);
            myemail.setText(myCandidat.getEmail());
            myemail.setTextColor(Color.GREEN);
            myemail.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            myemail.setPadding(5, 5, 5, 5);
            myemail.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
             tr.addView(myemail); // Adding textView to tablerow.
             
             /** Creating another textview **/
             mycivilite = new TextView(this);
             mycivilite.setText(myCandidat.getCivilite());
             mycivilite.setTextColor(Color.GREEN);
             mycivilite.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
             mycivilite.setPadding(5, 5, 5, 5);
             mycivilite.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
              tr.addView(mycivilite); // Adding textView to tablerow.
              
              myexperience = new TextView(this);
              myexperience.setText(myCandidat.getNb_annee_exp());
              myexperience.setTextColor(Color.GREEN);
              myexperience.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
              myexperience.setPadding(5, 5, 5, 5);
              myexperience.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
               tr.addView(myexperience); // Adding textView to tablerow.
               
               /** Creating another textview **/
               mytype = new TextView(this);
               mytype.setText(myCandidat.getType_demande());
               mytype.setTextColor(Color.GREEN);
               mytype.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
               mytype.setPadding(5, 5, 5, 5);
               mytype.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                tr.addView(mytype); // Adding textView to tablerow.
                
                mydate = new TextView(this);
                mydate.setText(myCandidat.getDate_demande());
                mydate.setTextColor(Color.GREEN);
                mydate.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
                mydate.setPadding(5, 5, 5, 5);
                mydate.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                 tr.addView(mydate); // Adding textView to tablerow.
                 
                 action= new Button(this);
                 action.setText("voir CV");
                 action.setPadding(5,5,5,5);
                 
                 OnClickListenerShowCV listnerShowCv = new OnClickListenerShowCV ();
                 listnerShowCv.setCv_path(myCandidat.getPath());
                 action.setOnClickListener(listnerShowCv);
//                 action.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                    	 path=myCandidat.getPath();
//                    	 System.out.println("mypath is "+path);
//                         File file = new File("/sdcard/download/cv.pdf");
//
//                         if (file.exists()) {
//                             Uri path = Uri.fromFile(file);
//                             Intent intent = new Intent(Intent.ACTION_VIEW);
//                             intent.setDataAndType(path, "application/pdf");
//                             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                             try {
//                                 startActivity(intent);
//                             } 
//                             catch (ActivityNotFoundException e) {
//                                 Toast.makeText(table.this, 
//                                     "No Application Available to View PDF", 
//                                     Toast.LENGTH_SHORT).show();
//                             }
//                         }
//                     }
//                 });
                 tr.addView(action);
                 suprimer= new Button(this);
                 
                 suprimer.setText("Supprimer");
                
                 suprimer.setPadding(5,5,5,5);
                 OnClickListenerDelet listnerDelet = new OnClickListenerDelet ();
                 listnerDelet.setId_condidat(myCandidat.getId_candidat());
                 suprimer.setOnClickListener(listnerDelet);
                 tr.addView(suprimer);

 
            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }
    
    
	public static List<Candidat> getData() {

		List<Candidat> listCandidat = new ArrayList<Candidat>();

		Dao db = null;
		try {
			db = new Dao();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {
			/*"create table administrateur ( id INTEGER, "
//										+ "login VARCHAR(100) , password VARCHAR(100));"*/
//			db.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal,"
//				+ "type_demande varchar(100),path varchar(100),date_demande timestamp)");
//			db.update("INSERT INTO candidat VALUES(0,'dddd','sara','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
//			db.update("INSERT INTO candidat VALUES(1,'dddd','salma','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
//			db.update("create table administrateur ( id INTEGER, login VARCHAR(100) , password VARCHAR(100));");
//			db.update("insert into administrateur(id, login, password) values (1, 'admin' , 'admin');");
			listCandidat=db.selectCandidat("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat  ORDER BY date_demande DESC");
			db.shutdown();

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return listCandidat;
	}
    class OnClickListenerDelet implements OnClickListener{
    	
    	String id_condidat;
        public void  setId_condidat(String id_condidat){
        	this.id_condidat=id_condidat;
        }
        public String getId_condidat(){
        	return id_condidat;
        }
		@Override
		public void onClick(View arg0) {
			try {
					myDataAccess.setIdCandidat(getId_condidat());
					manager.executeBusiness("deleteCandidat",true);
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
    
  class OnClickListenerShowCV implements OnClickListener{
    	
    	String cv_path;
        public void  setCv_path(String cv_path){
        	this.cv_path=cv_path;
        }
        public String getCv_path(){
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


//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.widget.TableLayout.LayoutParams;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//
//public class table extends Activity {
//	
//
//	@SuppressLint("NewApi")
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		
//	 
//	        //Create the layout
//	        TableLayout MainLayout = new TableLayout(this);
//	        MainLayout.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.FILL_PARENT));
//	        MainLayout.setStretchAllColumns(true);
//	 
//	        //Create the first row and add two text views
//	        TableRow row1 = new TableRow(this);
//	        TextView text1 = new TextView(this);
//	        text1.setText("Test1");
//	        TextView text2 = new TextView(this);
//	        text2.setText("Test2");
//	        text2.setGravity(android.view.Gravity.RIGHT);
//	        row1.addView(text1);
//	        row1.addView(text2);
//	        MainLayout.addView(row1);
//	 
//	        //Create the second row and add two text views
//	        TableRow row2 = new TableRow(this);
//	        TextView text3 = new TextView(this);
//	        text3.setText("Test3");
//	        TextView text4 = new TextView(this);
//	        text4.setText("Test4");
//	        text4.setGravity(android.view.Gravity.RIGHT);
//	        row2.addView(text3);
//	        row2.addView(text4);
//	        MainLayout.addView(row2);
//	 
//	        //Set the view
//	        setContentView(MainLayout);
//	    }
////		setContentView(R.layout.table);
////		TableLayout t1;
////		
////
////		TableLayout tl = (TableLayout) findViewById(R.id.main_table);
////		
////
////          
////        LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,
////                        LayoutParams.FILL_PARENT);
////
////        for (int i = 0; i < 50; i++) {
////        	 TableRow tr = new TableRow(this);
////        	  TextView result = new TextView(this);
////              result.setBackgroundColor(Color.LTGRAY);
////              result.setTextColor(Color.DKGRAY);
////              result.setGravity(Gravity.CENTER);
////              result.setPadding(2, 2, 2, 2);
////              result.setText("test");
////
////              result.setLayoutParams(layoutParams);
////                tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
////                                LayoutParams.WRAP_CONTENT));
////                tr.addView(result);
////                tl.addView(tr, layoutParams);
////        }
////}
////
////public TextView generateTextView(String texte, LayoutParams ly) {
////        TextView result = new TextView(this);
////        result.setBackgroundColor(Color.LTGRAY);
////        result.setTextColor(Color.DKGRAY);
////        result.setGravity(Gravity.CENTER);
////        result.setPadding(2, 2, 2, 2);
////        result.setText(texte);
////        result.setLayoutParams(ly);
////        return result;
////}
//}
