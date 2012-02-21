package com.aniXification.android.lovemeter;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoveMeterResultActivity extends Activity{

	TextView tvResult;
	Button btnShare;
	String[] gotBread;
	Button btnHelp;
	String resultText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		tvResult = (TextView) findViewById(R.id.tvResult);
		btnShare = (Button) findViewById(R.id.btnShare);
		btnHelp = (Button) findViewById(R.id.btnHelp);

		// gotBasket
		Bundle gotBasket = getIntent().getExtras();
		gotBread = gotBasket.getStringArray("key");
		
		String calculatedLove = gotBread[0];
		String name1 = gotBread[1];
		String name2 = gotBread[2];
		
		resultText = name1 + "'s love affinity with "  + name2 + " is " + "\n "+ calculatedLove + "%";
		tvResult.setText(resultText);
		
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
		
	}
	
	/*
	 * Share Button Clicked
	 * */
	public void btnShareClicked(View view){
		 Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
		 shareIntent.setType("text/plain");
		 shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, resultText + ". via http://market.android.com/details?id=com.aniXification.android.lovemeter");
		 view.getContext().startActivity(Intent.createChooser(shareIntent, "Share via"));
	}
	
	/*
	 * Help Button Clicked
	 * */
	public void onClickHelpBtn(View view){
		Intent intent = new Intent(this, HelpActivity.class);
		startActivity(intent);
	}

}
