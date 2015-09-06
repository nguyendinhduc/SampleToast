package com.ducnd.bai10;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btShowToast;
	private MyToast myToast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myToast = new MyToast(MainActivity.this);
		btShowToast = (Button)findViewById(R.id.btShowToast);
		btShowToast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				myToast.rdSign();
				myToast.rdSign();
				myToast.randomNext();
				myToast.showToast();
			}
		});
			
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
