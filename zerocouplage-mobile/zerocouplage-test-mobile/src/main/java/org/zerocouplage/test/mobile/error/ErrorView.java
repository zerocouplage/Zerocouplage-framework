package org.zerocouplage.test.mobile.error;

import java.util.HashMap;

import org.zerocouplage.test.mobile.view.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ErrorView extends Activity {
	
	TextView values;
	private Bundle getintent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		values=(TextView)findViewById(R.id.error);
		getintent = getIntent().getExtras();
		if (getintent != null) {
		values.setText("your firstname is "+getintent.getString("firstName")+" your lastname is "+ getintent.getString("lastName")+" but it contains the error "+ getintent.getString("error_lastName") );
		
		}
	}
		
		
}
