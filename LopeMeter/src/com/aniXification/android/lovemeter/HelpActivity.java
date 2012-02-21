package com.aniXification.android.lovemeter;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class HelpActivity extends Activity {

	WebView wvgetstarted, wvcalculation, wvrequirements;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		// had to use webview for the texts in the TEXTVIEW. Just to have 'em
		// aligned!! :)

		// webview for help -> how to get started!
		wvgetstarted = (WebView) findViewById(R.id.wvgetstarted);
		wvgetstarted.setVerticalScrollBarEnabled(true);
		wvgetstarted.loadData(getString(R.string.getstarted), "text/html",
				"utf-8");

		// webview for help -> how to get started!
		wvcalculation = (WebView) findViewById(R.id.wvcalculation);
		wvcalculation.setVerticalScrollBarEnabled(true);
		wvcalculation.loadData(getString(R.string.calculation), "text/html",
				"utf-8");

		// webview for help -> how to get started!
		wvrequirements = (WebView) findViewById(R.id.wvrequirements);
		wvrequirements.setVerticalScrollBarEnabled(true);
		wvrequirements.loadData(getString(R.string.requirements), "text/html",
				"utf-8");

	}

}
