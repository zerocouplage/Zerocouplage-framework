package org.zerocouplage.test.mobile.view;

import java.io.File;

import org.zerocouplage.test.mobile.bean.PathOut;
import org.zerocouplage.test.mobile.bean.UserBeanResult;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class ShowCv extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PathOut outCv = new PathOut();
		Bundle getintent = getIntent().getExtras();

		outCv = (PathOut)getintent.getSerializable("outCv");

		File file = new File("/sdcard/download/cv.pdf");

        if (file.exists()) {
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            } 
            catch (ActivityNotFoundException e) {
                Toast.makeText(ShowCv.this, 
                    "No Application Available to View PDF", 
                    Toast.LENGTH_SHORT).show();
            }
        }
    }

}
