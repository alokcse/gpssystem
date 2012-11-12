package alok.ku.cse;


import java.util.Locale;

import alok.ku.cse.showActivity;
import alok.ku.cse.DatabasetimerActivity;

import alok.ku.cse.DatabasetimerActivity;
//import alok.ku.cse.showActivity;
import alok.ku.cse.R;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class DatabasetimerActivity extends Activity {
	
	EditText txtlat;
	EditText txtlong;
	
	Button btnreset;
	Button btnAdd;
	Button btnShow;
	
	public static SQLiteDatabase locationDB;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     // Creating Database
        locationDB =  this.openOrCreateDatabase("test.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        locationDB.setVersion(1);
        locationDB.setLocale(Locale.getDefault());
        locationDB.setLockingEnabled(true);
 // Creating Table
        
        locationDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "locationlist" +
                " (LATITUDE TEXT, LONGITUDE TEXT);");
        
        
        txtlat=(EditText)findViewById(R.id.txtlat);
    	txtlong=(EditText)findViewById(R.id.txtlong);
    	
    	btnreset=(Button)findViewById(R.id.btnreset);
        btnAdd=(Button)findViewById(R.id.btnAdd);
    	btnShow=(Button)findViewById(R.id.btnShow);
    	
    	btnreset.setOnClickListener(new OnClickListener() 
		{
			
			public void onClick(View v) {
				txtlat.setText("");
				txtlong.setText("");
				
			}
		});
    	
btnAdd.setOnClickListener(new OnClickListener() {
			
			//@Override
			public void onClick(View v) {
				
				double t=Double.parseDouble(txtlat.getText().toString());
				double a=Double.parseDouble(txtlong.getText().toString());
				locationDB.execSQL("INSERT INTO " +
                        "locationlist" +
                        " Values ('"+t+"','"+a+"');");
//				
				
				Toast.makeText(getApplicationContext(), "Added Latitude and Longitude", Toast.LENGTH_LONG).show();
			}
		});
btnShow.setOnClickListener(new OnClickListener() {
	
	//@Override
	public void onClick(View v) {
		Intent i=new Intent(DatabasetimerActivity.this,showActivity.class);
		startActivity(i);
		
	}
});
    	
    }

    }
