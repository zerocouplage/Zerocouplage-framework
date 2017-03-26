package org.zerocouplage.test.mobile.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;
import org.zerocouplage.test.mobile.bean.UserBeanResult;

public class UserDisplayView extends Activity {

	private static final long serialVersionUID = 1L;
	UserBeanResult userout;
	private IZCManager manager;
	private Button back;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main1);
		
		manager = ZCManagerFactory.getNewManager(this);
		TextView tv = (TextView) findViewById(R.id.hello);
		Bundle getintent = getIntent().getExtras();
		userout = (UserBeanResult) getintent.getSerializable("userout");

		tv.setText("Merci " + userout.getCivilite() + " "+ userout.getFirstname() + " "
				+ userout.getLastname()+" votre demande a �t� envoy�e avec succ�s !");
		
		
		
		
		
		back = (Button) findViewById(R.id.back);
		
		  
		  
		  back.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					try {
					
						manager.executeBusiness("return");

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}
			});
		
//		StringBuilder fileData = new StringBuilder();
//        BufferedReader reader;
//		try {
//			reader = new BufferedReader(new FileReader(out.getFile()));
//			 char[] buf = new char[1024];
//		        int numRead = 0;
//		        while ((numRead = reader.read(buf)) != -1) {
//		           StringBuilder test= fileData.append(buf, 0, numRead);
//		            System.out.println("the contenu is +"+test);
//		        }
//		        reader.close();
//		      fileData.toString();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
