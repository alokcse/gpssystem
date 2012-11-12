package alok.ku.cse;



import java.util.ArrayList;



import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class showActivity extends ListActivity {
	
	ArrayList<String> searchResult;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		searchResult=new ArrayList<String>();
		Cursor c = DatabasetimerActivity.locationDB.rawQuery("SELECT * FROM locationlist", null);

		if (c != null) {
			if (c.moveToFirst()) {
				do {
					String longitude = c.getString(c
							.getColumnIndex("LATITUDE"));
					String latitude= c.getString(c
							.getColumnIndex("LONGITUDE"));
					//String price= c.getString(c
						//	.getColumnIndex("price"));
					searchResult.add("" + longitude +"\n" + latitude);
				} while (c.moveToNext());
			}
		}
		
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,searchResult));
	

	}
}
