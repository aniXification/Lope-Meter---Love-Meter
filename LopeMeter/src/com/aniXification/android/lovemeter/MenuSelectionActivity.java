package com.aniXification.android.lovemeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//import com.aniXification.android.lovemeter.lovequotes.LoveQuotesActivity;
import com.google.ads.*;

public class MenuSelectionActivity extends Activity implements OnClickListener {

	Button btnLoveMeter, btnHelp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.mainmenu);

		initialize();

		 /*
		 * add starts
		 * */
		
        AdView adview = (AdView)findViewById(R.id.adView);

        // Initiate a generic request to load it with an ad
        AdRequest re = new AdRequest();
        //re.setTesting(true);
        re.setGender(AdRequest.Gender.MALE); 
        adview.loadAd(re);
		
		/*
		 * add ends
		 * */

		btnLoveMeter.setOnClickListener(this);
		btnHelp.setOnClickListener(this);

	}

	private void initialize() {

		btnLoveMeter = (Button) findViewById(R.id.btnLoveMeter);
		btnHelp = (Button) findViewById(R.id.btnHelp);

	}

	/*@Override
	public void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}*/

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent(
					"com.aniXification.android.lovemeter.AboutUsActivity");
			startActivity(i);
			break;

		case R.id.preferences:
			Intent p = new Intent(
					"com.aniXification.android.lovemeter.PrefsActivity");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}

		return false;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLoveMeter:
			// Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this, LoveMeterActivity.class);
			startActivity(i);
			break;

		case R.id.btnHelp:
			Intent intent = new Intent(this, HelpActivity.class);
			startActivity(intent);
			break;
			

		default:
			break;
		}

	}

}
