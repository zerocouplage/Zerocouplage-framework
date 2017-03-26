package org.zerocouplage.test.mobile.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.zerocouplage.test.mobile.bean.UserBeanResult;

public class UserDisplayView extends Activity {

	private static final long serialVersionUID = 1L;
	UserBeanResult out;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		Bundle getintent = getIntent().getExtras();
		out = (UserBeanResult) getintent.getSerializable("out");

		tv.setText("Hello ! " + out.getFirstname() + " " + out.getLastname()
				+ "\n You have : " + out.getAgeRes() + "\n Your size: "
				+ out.getTailleRes() + "\n You date of birth :"
				+ out.getDate_naissance() + " \n Your response:"
				+ out.getQuestionRes()+ "\n "+out.getFile().getAbsolutePath());
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

		setContentView(tv);
	}

}
